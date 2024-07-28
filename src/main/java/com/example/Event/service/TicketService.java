package com.example.Event.service;

import com.example.Event.exeption.NoSeatsAvailableException;
import com.example.Event.modal.Event;
import com.example.Event.modal.Ticket;
import com.example.Event.modal.User;
import com.example.Event.repository.EventRepository;
import com.example.Event.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private  final EventRepository eventRepository;
    private final TicketRepository ticketRepository;


    public Ticket newTicket(Ticket ticket) {



        return ticketRepository.save(ticket);
    }
    public Ticket bookTicket(Integer eventAvailableSeats , User user1 , Event event , Ticket ticket) throws NoSeatsAvailableException {
        System.out.println("hanta asi blchich ha ch7al tlkrasa " + eventAvailableSeats);
        if (eventAvailableSeats >= 0) {
        event.setSeats(eventAvailableSeats - 1);
        ticket.setEvent(event);
        ticket.setUser(user1);
        ticket.setTicketPrice(event.getTicketPrice());
        eventRepository.save(event);
       return ticketRepository.save(ticket);

    }else {
            String errorMessage = "Malheureusement Les Tickets Sont épuisés " ;
            throw new NoSeatsAvailableException(errorMessage);
        }
    }



}
