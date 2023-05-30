package com.example.smartContact.controller;
import com.example.smartContact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;;
import javax.validation.Valid;
import com.example.smartContact.model.User;


@Controller
public class homeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String solve(){
        return "index2";
    }
    @PostMapping("/dashboard")
    public String solve(@Valid @ModelAttribute("user") User user , BindingResult result){
        if(result.hasErrors()){
            return "index1";
        }
        return "index2";
    }

}
