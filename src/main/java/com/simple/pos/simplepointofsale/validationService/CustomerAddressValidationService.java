package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.CustomerAddressesDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CustomerAddressValidationService {
    
    boolean customerAddressValidation(
        CustomerAddressesDto customerAddresseDto,
        RedirectAttributes redirectAttributes
    );
}
