package com.example.smartContact.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.smartContact.model.login;
import com.example.smartContact.model.user;
import com.example.smartContact.repository.userRepository;
@Controller
public class loginController {
    @Autowired
    private  userRepository userRepository;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String solve1(){
        return "index1";
    }

    @RequestMapping(value = "/dash",method = RequestMethod.POST)
    public String solve(@ModelAttribute("login") login login, HttpSession session ){

        user user=this.userRepository.findByEmail(login.getE());
        if(user == null){
            return "index1";
        }
        session.setAttribute("email",user.getEmail());
        session.setAttribute("id",user.getId());
        return "index2";
    }
}
