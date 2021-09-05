package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;
import com.simple.pos.simplepointofsale.service.UserService;
import com.simple.pos.simplepointofsale.validationService.RegisterValidationService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RegisterValidationService registerValidationService;

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
        String result = "";

        if(userService.findByEmail(registrationDto.getEmail()) != null){
            redirectAttributes.addFlashAttribute("message", "Email already registred");
            result = "redirect:/registration";
        }else{
            if(!registerValidationService.registrationValidation(registrationDto, redirectAttributes)){
                userService.save(registrationDto);
                redirectAttributes.addFlashAttribute("message", "You're register successful");
                result = "redirect:/login";
            }else{
                result = "redirect:/registration";
            }
        }

        return result;
    }
}
