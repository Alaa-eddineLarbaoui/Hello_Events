package com.example.Event.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Double ticketPrice;


 @ManyToOne
 @JoinColumn(name="eventId")
    private Event event;

 @ManyToOne
 @JoinColumn(name ="userId")
 private User user;
}
