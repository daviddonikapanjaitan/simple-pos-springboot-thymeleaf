package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.PaymentMethodDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface PaymentMethodValidationService {
    
    boolean paymentMethodValidation(PaymentMethodDto paymentMethodDto, RedirectAttributes redirectAttributes);
}
