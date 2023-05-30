package com.example.smartContact.controller;

import com.example.smartContact.model.user;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.smartContact.model.contact;
import com.example.smartContact.repository.userRepository;
import com.example.smartContact.repository.contactRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class showContactController {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private contactRepository contactRepository;



    @GetMapping("/showcontact")
    public void solve(HttpSession session, @RequestParam(defaultValue = "0") Integer pageNo,
                      @RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(value = "search",required = false ) String search){

        Optional<user> user = userRepository.findById(1);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if(search == null){
            Page<contact> contacts = contactRepository.findByuser(user.get(), pageable);
        }else{
            Page<contact> contacts = contactRepository.findBySpecificuser(1, pageable,search);

        }

    }
}
