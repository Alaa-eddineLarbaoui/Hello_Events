package com.example.Event.modal;

import com.example.Event.enums.eventcategory;
import com.example.Event.enums.location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "event") @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Builder
public class Event {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer eventId ;
    private String eventName ;
    private String eventDescription ;
    private String picture;
    @Enumerated(EnumType.STRING)
    private com.example.Event.enums.location location ;
    private LocalDate eventDate ;
    private LocalDateTime eventStartTime ;
    private eventcategory eventCategory;
    private Integer seats ;
    private double ticketPrice ;




    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Ticket> ticketList ;


    
}
