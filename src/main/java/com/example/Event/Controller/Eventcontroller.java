package com.example.Event.Controller;

import com.example.Event.modal.Event;
import com.example.Event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class Eventcontroller {

    @Autowired
    private EventService eventservice;
    @PostMapping("/event")
    public Event addEvenement(@RequestBody Event event){
        return eventservice.addEvent(event);
    }
    @GetMapping("/eventAll")
    public List<Event>AfficherEvent(){
        return eventservice.showEvents();
    }




}

