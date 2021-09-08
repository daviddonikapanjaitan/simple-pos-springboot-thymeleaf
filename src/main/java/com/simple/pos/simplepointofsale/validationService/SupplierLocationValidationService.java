package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.SupplierLocationDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SupplierLocationValidationService {
    
    boolean supplierLocationValidation(
        SupplierLocationDto supplierLocationDto,
        RedirectAttributes redirectAttributes
    );
}
