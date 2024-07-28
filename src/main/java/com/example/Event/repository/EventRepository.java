package com.example.Event.repository;

import com.example.Event.enums.eventcategory;
import com.example.Event.modal.Event;
import com.fasterxml.jackson.databind.DatabindException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    //List<Event> findByEventDate(Date eventDate);
    List<Event> findAllByDateEvenementOrCategorieOrLieu(Date date, eventcategory eventCategory, String lieu);
}
