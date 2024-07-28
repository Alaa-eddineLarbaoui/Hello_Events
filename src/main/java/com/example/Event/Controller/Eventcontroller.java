package com.example.Event.Controller;

import com.example.Event.enums.eventcategory;

import com.example.Event.enums.location;

import com.example.Event.modal.Event;
import com.example.Event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@RestController

public class Eventcontroller {

    @Autowired
    private EventService eventservice;
    @PostMapping("admin/addEvent")
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

    @DeleteMapping("admin/deleteEvent/{id}")
    public String deleteEvent (@PathVariable Integer id){
       return  eventservice.deleteEvent(id);
    }

    @PutMapping("admin/updateEvent/{idEvent}")
    public  Event UpdateEvent(Integer id , Event event){
        return eventservice.updateEvent(id,event);
    }

    @GetMapping("/search")
    public List<Event> search (@RequestParam (required = false) String eventName ,
                               @RequestParam (required = false) LocalDate eventDate ,
                               @RequestParam (required = false)location location,
                               @RequestParam (required = false) String description ,
                               @RequestParam (required = false) eventcategory category,
                               @RequestParam (required = false) Double minPrice,
                               @RequestParam (required = false) Double maxPrice

                               ){
        return eventservice.searcheEvents(eventName ,description , location ,eventDate , category , minPrice , maxPrice);}

//    @GetMapping("/eventBydate/{date}")
//    public List<Event> Findbydate (@PathVariable Date date){
//        return eventservice.FindbydateEvent(date);
//    }

    @GetMapping("/searchEvents")
    public List<Event> findEvents(@RequestParam(required = false) Date  date , @RequestParam(required = false) eventcategory categorie, @RequestParam(required = false) String lieu){
        return eventservice.findEvents(date,categorie,lieu);

    }


}

