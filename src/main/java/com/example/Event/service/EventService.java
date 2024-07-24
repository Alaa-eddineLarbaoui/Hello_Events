package com.example.Event.service;


import com.example.Event.modal.Event;
import com.example.Event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteEvent (Integer id){
         eventRepo.deleteById(id);
    }



}
