package com.example.smartContact.controller;

import com.example.smartContact.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.smartContact.model.contact;
import com.example.smartContact.repository.contactRepository;
import com.example.smartContact.repository.userRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class addContactConntroller {
    @Autowired
    private contactRepository contactRepository;
    @Autowired
    private userRepository userRepository;
    @GetMapping("/adding")
     public String solve(@ModelAttribute("contact") contact contact, @RequestParam("image")MultipartFile file    ){
        contact contact1=new contact();
        contact1.setName("rahul");
        contact1.setEmail("rahul@gmail.com");
        contact1.setPhone("7096804652");
        contact1.setNickName("rahi");
        contact1.setWork("geb");
        contact1.setImage(file.getOriginalFilename());
        contact1.setDescription("hiii");
        user user=userRepository.getById(1);
        contact1.setUser(user);
        contactRepository.save(contact1);
        return "index1";
     }


}
