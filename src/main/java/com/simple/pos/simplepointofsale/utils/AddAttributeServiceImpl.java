package com.simple.pos.simplepointofsale.utils;

import com.simple.pos.simplepointofsale.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class AddAttributeServiceImpl implements AddAttributeService{

    @Autowired
    UserService userService;

    @Override
    public void addFirstNameAttribute(Model model) {
        String firstName = userService.getFirstName();

        model.addAttribute("first_name", firstName);
    }
}
