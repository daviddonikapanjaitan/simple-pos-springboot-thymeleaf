package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;
     
    @GetMapping
    public String viewLoginMethodPage(){
        String result = "";

        if(userService.isAuthenticated()){
            result = "redirect:/";
        }else{
            result = "login_ui/login";
        }

        return result;
    }
}
