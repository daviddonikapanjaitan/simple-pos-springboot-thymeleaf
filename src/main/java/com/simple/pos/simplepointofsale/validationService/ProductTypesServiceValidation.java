package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductTypesDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ProductTypesServiceValidation {
 
    boolean productTypesValidation(
        ProductTypesDto productTypesDto,
        RedirectAttributes redirectAttributes
    );
}
