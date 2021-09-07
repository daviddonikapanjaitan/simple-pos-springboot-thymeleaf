package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.AddressesDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AddressesValidationService {
    
    boolean addressesValidation(
        AddressesDto addressesDto,
        RedirectAttributes redirectAttributes
    );
}
