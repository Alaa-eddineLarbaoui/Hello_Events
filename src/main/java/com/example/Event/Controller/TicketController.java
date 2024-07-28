package com.example.Event.Controller;

import com.example.Event.PDF.PDFGenerator;

import com.example.Event.exeption.NoSeatsAvailableException;

import com.example.Event.modal.Event;
import com.example.Event.modal.Ticket;

import com.example.Event.repository.EventRepository;

import com.example.Event.repository.UserRepository;
import com.example.Event.service.TicketService;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

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
    private final TicketService ticketService;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final PDFGenerator pdfGenerator;




    @Transactional
    @PostMapping("user/GetYourTicket/{id}")
        public ResponseEntity<?> getTicket(Authentication authentication , @RequestBody  Ticket ticket , @PathVariable Integer id) throws NoSeatsAvailableException {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        var user1 = userRepository.findByUsername(authentication.getName());
        Integer eventAvailableSeats = event.getSeats();
        try{
            Ticket bookedTicket = ticketService.bookTicket(eventAvailableSeats,user1,event,ticket);

            byte[] pdfBytes = pdfGenerator.generateTicketPDF(bookedTicket);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(event.getEventName(), "ticket_" + user1.getUsername() + ".pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (NoSeatsAvailableException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (DocumentException e) {
            return ResponseEntity.internalServerError().body("Error generating PDF");
        }


    }


}
