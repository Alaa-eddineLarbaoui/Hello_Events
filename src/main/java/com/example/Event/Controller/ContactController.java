package com.example.Event.Controller;

import com.example.Event.modal.Contact;
import com.example.Event.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/sendMessage")
    public Contact  SendMessage (@RequestBody  Contact contact){
        return contactService.SendMessage(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> showAllMessages(){
        return contactService.Showsmessages();
    }
}
