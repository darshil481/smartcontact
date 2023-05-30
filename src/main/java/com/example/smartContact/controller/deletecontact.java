package com.example.smartContact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.smartContact.repository.contactRepository;

@RestController

public class deletecontact {
    @Autowired
    private contactRepository contactRepository;
    @DeleteMapping("/deletecontact")
    public void solve(@RequestParam("id") int id){
        contactRepository.deleteById(id);
    }

}
