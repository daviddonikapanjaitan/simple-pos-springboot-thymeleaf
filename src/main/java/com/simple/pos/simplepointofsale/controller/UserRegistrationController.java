package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;
import com.simple.pos.simplepointofsale.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
   
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration_ui/registration";
    }

    @PostMapping
    public String registerUserAccount(
        @ModelAttribute("user") UserRegistrationDto registrationDto,
        RedirectAttributes redirectAttributes
    ){
        String result = "redirect:/login";

        if(userService.findByEmail(registrationDto.getEmail()) != null){
            redirectAttributes.addFlashAttribute("message", "Email already registred");
        }else{
            userService.save(registrationDto);
            redirectAttributes.addFlashAttribute("message", "You're register successful");
        }

        return result;
    }
}
