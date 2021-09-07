package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Service
public class CustomerValidationServiceImpl implements CustomerValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean customerValidation(
        CustomerDto customerDto,
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;
        if(
            customerDto.getPaymentMethodCode() == null || 
            customerDto.getCustomerName() == null ||
            customerDto.getCustomerPhone() == null || 
            customerDto.getCustomerEmail() == null || 
            customerDto.getDateBecomeCustomer() == null ||
            customerDto.getPaymentDetails() == null || 
            customerDto.getOtherCustomerDetails() == null ||
            customerDto.getPaymentMethodCode().equalsIgnoreCase("") || 
            customerDto.getCustomerName().equalsIgnoreCase("") ||
            customerDto.getCustomerPhone().equalsIgnoreCase("") || 
            customerDto.getCustomerEmail().equalsIgnoreCase("") || 
            customerDto.getPaymentDetails().equalsIgnoreCase("") || 
            customerDto.getOtherCustomerDetails().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(!validationUtilsService.checkPaymentMethod(customerDto.getPaymentMethodCode())){
            redirectAttributes.addFlashAttribute("message", "Invalid Payment Method Code");
        }else if(
            customerDto.getCustomerName().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Customer Name length must larger than 5");
        }else if (!validationUtilsService.phoneValidation(customerDto.getCustomerPhone())){
            redirectAttributes.addFlashAttribute("message", "Customer Phone Invalid");
        }else if(!validationUtilsService.validateEmail(customerDto.getCustomerEmail())){
            redirectAttributes.addFlashAttribute("message", "Customer Email Invalid");
        }else if(
            customerDto.getPaymentDetails().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Payment Details length must larger than 5");
        }else if(
            customerDto.getOtherCustomerDetails().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Other Customer Details length must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}