package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductsDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ProductsValidationService {
 
    boolean productsValidation(
        ProductsDto productsDto,
        RedirectAttributes redirectAttributes
    );
}
