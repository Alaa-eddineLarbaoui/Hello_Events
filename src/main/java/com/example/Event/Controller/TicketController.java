package com.example.Event.Controller;

import com.example.Event.config.JwtHelper;
import com.example.Event.modal.Event;
import com.example.Event.modal.Ticket;
import com.example.Event.modal.User;
import com.example.Event.repository.EventRepository;
import com.example.Event.repository.TicketRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
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
    @Autowired
    private HttpSession httpSession;


    @PostMapping("user/GetYourTicket/{id}")
        public Ticket getTicket(Authentication authentication ,@RequestBody  Ticket ticket , @PathVariable Integer id) {
           Event event = eventRepository.findById(id).get();

        User user = (User) authentication.getPrincipal();
        System.out.println("hada l principal" + user);




           event.setSeats(event.getSeats()-1);

           ticket.setEvent(event);
           ticket.setUser(user);
           eventRepository.save(event);

            return ticketRepository.save(ticket);

        }


}
