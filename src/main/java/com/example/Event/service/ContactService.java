package com.example.Event.service;

import com.example.Event.modal.Contact;
import com.example.Event.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService{

    @Autowired
    public ContactRepository contactRepository;

    public  Contact SendMessage(Contact contact){
        return contactRepository.save(contact);
    }

}
