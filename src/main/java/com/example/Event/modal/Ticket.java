package com.example.Event.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @AllArgsConstructor
@NoArgsConstructor @Builder
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Double ticketPrice;


 @ManyToOne
 @JsonIgnore
 @JoinColumn(name="eventId")
    private Event event;

 @ManyToOne
 @JsonIgnore
 @JoinColumn(name ="userId")
 private User user;
}
