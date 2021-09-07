package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductSuppliersDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ProductSuppliersValidationService {

    boolean productSuppliersValidation(ProductSuppliersDto productSuppliersDto,
        RedirectAttributes redirectAttributes);
}
