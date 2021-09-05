package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class RegisterValidationServiceImpl implements RegisterValidationService{

    @Override
    public boolean registrationValidation(
        UserRegistrationDto userRegistrationDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            userRegistrationDto.getEmail() == null || 
            userRegistrationDto.getFirstName() == null ||
            userRegistrationDto.getLastName() == null || 
            userRegistrationDto.getPassword() == null ||
            userRegistrationDto.getEmail() == "" || 
            userRegistrationDto.getFirstName() == "" ||
            userRegistrationDto.getLastName() == "" || 
            userRegistrationDto.getPassword() == ""
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(
            userRegistrationDto.getEmail().length() < 5 
        ){
            redirectAttributes.addFlashAttribute("message", "Field Email must length than 5");
        }else if(
            userRegistrationDto.getFirstName().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field First name must length than 5");
        }else if(
            userRegistrationDto.getLastName().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Last Name must length than 5");
        }
        else if(
            userRegistrationDto.getPassword().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Password must length than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
