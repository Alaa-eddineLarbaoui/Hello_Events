package com.example.Event.Controller;

import com.example.Event.config.JwtHelper;
import com.example.Event.enums.role;
import com.example.Event.implementation.UserDetailsServiceImpl;
import com.example.Event.modal.Event;
import com.example.Event.modal.Ticket;
import com.example.Event.modal.User;
import com.example.Event.repository.EventRepository;
import com.example.Event.repository.TicketRepository;
import com.example.Event.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor

@RestController

public class TicketController {

    @Autowired
    AuthenticationManager authenticationManager;
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;




    @Transactional
    @PostMapping("user/GetYourTicket/{id}")
        public Ticket getTicket(Authentication authentication ,@RequestBody  Ticket ticket , @PathVariable Integer id) {
           Event event = eventRepository.findById(id).get();
           var user1 = userRepository.findByUsername(authentication.getName());
           event.setSeats(event.getSeats()-1);
           ticket.setEvent(event);
           ticket.setUser(user1);
           ticket.setTicketPrice(event.getTicketPrice());

           eventRepository.save(event);


            return ticketRepository.save(ticket);

        }


}
