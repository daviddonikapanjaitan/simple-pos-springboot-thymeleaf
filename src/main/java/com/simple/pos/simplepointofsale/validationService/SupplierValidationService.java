package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.SuppliersDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SupplierValidationService {
    
    boolean supplierValidation(SuppliersDto suppliersDto,
        RedirectAttributes redirectAttributes);
}
