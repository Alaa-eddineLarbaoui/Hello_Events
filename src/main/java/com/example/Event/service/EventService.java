package com.example.Event.service;


import com.example.Event.modal.Event;
import com.example.Event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService  {
    @Autowired
    private EventRepository eventRepo;

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }



}
