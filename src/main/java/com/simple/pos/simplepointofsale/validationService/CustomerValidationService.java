package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.CustomerDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CustomerValidationService {
    
    boolean customerValidation(
        CustomerDto customerDto,
        RedirectAttributes redirectAttributes
    );
}
