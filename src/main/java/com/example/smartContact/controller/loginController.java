package com.example.smartContact.controller;

import com.example.smartContact.config.JwtService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.smartContact.model.Login;
import com.example.smartContact.model.User;
import com.example.smartContact.repository.UserRepository;

import java.util.Optional;

@RestController
public class loginController {
    @Autowired
    private UserRepository userRepository;
    private JwtService jwtService;

   @PostMapping("/dash")

    public String solve(@RequestBody() Login login, HttpSession session ){
        System.out.println(login.getE());
        String token=jwtService.generateToken(login.getE());
        System.out.println(token);
//        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getE(),login.getP()
//        ));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return token;
    }
}
