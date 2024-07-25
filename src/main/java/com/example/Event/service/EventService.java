package com.example.Event.service;


import com.example.Event.enums.eventcategory;
import com.example.Event.modal.Event;
import com.example.Event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
         return "Evenement supptimé avec succes";
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

    public List<Event> FindbydateEvent(Date eventDate){
        return eventRepo.findByEventDate(eventDate);
    }

}
