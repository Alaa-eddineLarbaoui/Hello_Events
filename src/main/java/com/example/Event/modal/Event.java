package com.example.Event.modal;

import com.example.Event.enums.eventcategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "event") @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Event {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer eventId ;
    private String eventName ;
    private String eventDescription ;
    private String picture;
    private String location ;
    private Date eventDate ;
    private LocalDate eventStartTime ;
    private eventcategory eventCategory;
    private Integer seats ;




    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Ticket> ticketList ;
}
