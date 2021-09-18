package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.model.User;
import com.simple.pos.simplepointofsale.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;
    

    @GetMapping("/profile")
    public String viewProfilePage(Model model){

        User user = userService.findUserPerSession();

        model.addAttribute("email", user.getEmail());
        model.addAttribute("first_name", user.getFirstName());
        model.addAttribute("last_name", user.getLastName());

        return "profile_ui/profile";
    }
}
