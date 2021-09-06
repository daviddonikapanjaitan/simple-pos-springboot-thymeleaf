package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.PaymentMethodDto;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class PaymentMethodValidationServiceImpl implements PaymentMethodValidationService{

    @Override
    public boolean paymentMethodValidation(
        PaymentMethodDto paymentMethodDto,
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            paymentMethodDto.getPaymentMethodId() == null || 
            paymentMethodDto.getPaymentMethodCode() == null ||
            paymentMethodDto.getPaymentMethodDescription() == null || 
            paymentMethodDto.getPaymentMethodId().intValue() == 0 || 
            paymentMethodDto.getPaymentMethodCode().equalsIgnoreCase("") ||
            paymentMethodDto.getPaymentMethodDescription().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(
            paymentMethodDto.getPaymentMethodCode().length() < 2
        ){
            redirectAttributes.addFlashAttribute("message", "Field First name must length than 5");
        }else if(
            paymentMethodDto.getPaymentMethodDescription().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Last Name must length than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
