package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ShoppingBasketDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ShoppingBasketValidationService {
    
    boolean shoppingBasketValidation(
        ShoppingBasketDto shoppingBasketDto,
        RedirectAttributes redirectAttributes
    );
}
