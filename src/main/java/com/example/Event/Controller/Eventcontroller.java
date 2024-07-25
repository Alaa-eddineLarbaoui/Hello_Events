package com.example.Event.Controller;

import com.example.Event.modal.Event;
import com.example.Event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController

public class Eventcontroller {

    @Autowired
    private EventService eventservice;
    @PostMapping("/addEvent")
    public Event addEvenement(@RequestBody Event event){
        return eventservice.addEvent(event);
    }
    @GetMapping("/getEvents")
    public List<Event>AfficherEvent(){
        return eventservice.showEvents();
    }
    @GetMapping("/getEvent")
    public Event AfficherEvent(Integer Idevent){
        return eventservice.showEvent(Idevent);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String deleteEvent (@PathVariable Integer id){
       return  eventservice.deleteEvent(id);
    }

    @PutMapping("/updateEvent/{idEvent}")
    public  Event UpdateEvent(Integer id , Event event){
        return eventservice.updateEvent(id,event);
    }
    @GetMapping("/eventBydate/{date}")
    public List<Event> Findbydate (@PathVariable Date date){
        return eventservice.FindbydateEvent(date);
    }



}

