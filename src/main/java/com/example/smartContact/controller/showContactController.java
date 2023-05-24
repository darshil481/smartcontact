package com.example.smartContact.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.smartContact.model.contact;
import com.example.smartContact.repository.userRepository;
import com.example.smartContact.repository.contactRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class showContactController {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private contactRepository contactRepository;
    @GetMapping("/showcontact")
    public List<contact> solve(HttpSession session){
       // int id=Integer.valueOf(session.getAttribute("id").toString());
        List<contact> list=contactRepository.findByUser(userRepository.findById(1));
        return list;
    }

}
