package com.example.Event.service;


import com.example.Event.enums.eventcategory;
import com.example.Event.enums.location;
import com.example.Event.modal.Event;
import com.example.Event.modal.QEvent;
import com.example.Event.repository.EventRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventService  {
    @Autowired
    private EventRepository eventRepo;

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> showEvents (){
        return eventRepo.findAll();
    }
    public String deleteEvent (Integer Idevent){
         eventRepo.deleteById(Idevent);
         return "Evenement supprimé avec succes";
    }
    public Event showEvent ( Integer Idevent){
        return eventRepo.findById(Idevent).get();
    }

    public Event updateEvent(Integer idEvenement,Event event){
        Event ev=showEvent(idEvenement);
        ev.setEventName(event.getEventName());
        ev.setEventDescription(event.getEventDescription());
        ev.setPicture(event.getPicture());
        ev.setLocation(event.getLocation());
        ev.setEventDate(event.getEventDate());
        ev.setEventStartTime(event.getEventStartTime());
        ev.setEventCategory(event.getEventCategory());
        ev.setSeats(event.getSeats());
        return eventRepo.save(ev);
    }

//    public List<Event> FindbydateEvent(Date eventDate){
//        return eventRepo.findByEventDate(eventDate);
//    }
    public List<Event> searcheEvents(String eventName , String description , location location , LocalDate eventDate , eventcategory category, Double minPrice , Double maxPrice ) {
        QEvent event = QEvent.event;
        BooleanBuilder builder = new BooleanBuilder();
        if (eventName != null && !eventName.isEmpty()) {
            builder.and(event.eventName.containsIgnoreCase(eventName));
        }
        if (description != null && !description.isEmpty()) {
            builder.and(event.eventDescription.containsIgnoreCase(description));
        }
        if (location != null) {
            builder.and(event.location.eq(location));
        }
        if (eventDate != null) {
            builder.and(event.eventDate.gt(eventDate));
        }
        if (category != null) {
            builder.and(event.eventCategory.eq(category));
        }
        if (minPrice != null) {
            builder.and(event.ticketPrice.goe(minPrice));
        }
        if (maxPrice != null) {
            builder.and(event.ticketPrice.goe(maxPrice));
        }
        return (List<Event>) eventRepo.findAll(builder);


    }
    public List<Event> findEvents(Date eventDate,eventcategory categorie,String lieu){
        return eventRepo.findAllByEventDateOrEventCategoryOrLocation(eventDate,categorie,lieu);

    }
}
