package com.example.smartContact.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;;
import javax.validation.Valid;
import com.example.smartContact.model.user;

@Controller
public class homeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String solve1(){
        return "index1";
    }
    @GetMapping("/register")
    public String solve(){
        return "index2";
    }
    @PostMapping("dashboard")
    public String solve(@Valid @ModelAttribute("user") user user ,BindingResult result){
        if(result.hasErrors()){
            return "index1";
        }
        return "index2";
    }

}
