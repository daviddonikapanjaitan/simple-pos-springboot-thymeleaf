package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.BasketItemsDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BasketItemsValidationService {
    
    boolean basketItemsValidation(
        BasketItemsDto basketItemsDto,
        RedirectAttributes redirectAttributes
    );
}
