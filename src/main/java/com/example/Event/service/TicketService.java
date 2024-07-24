package com.example.Event.service;

import com.example.Event.modal.Event;
import com.example.Event.modal.Ticket;
import com.example.Event.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {
    private final EventService eventService;
    private final TicketRepository ticketRepository;


    public Ticket newTicket(Ticket ticket) {
        Event event = new Event();

        return ticketRepository.save(ticket);
    }


}
