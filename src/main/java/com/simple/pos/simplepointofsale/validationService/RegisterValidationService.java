package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.UserRegistrationDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface RegisterValidationService {

    boolean registrationValidation(UserRegistrationDto userRegistrationDto, 
        RedirectAttributes redirectAttributes);
}
