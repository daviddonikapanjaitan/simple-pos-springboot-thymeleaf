package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.AddressTypesDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AddressTypesValidationService {
    
    boolean addressTypesValidation(
        AddressTypesDto addressTypesDto,
        RedirectAttributes redirectAttributes
    );
}
