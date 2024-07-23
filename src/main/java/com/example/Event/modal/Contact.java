package com.example.Event.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Contact {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer contactId ;
    private String contactName ;
    private String contactEmail ;
    private String message ;
}
