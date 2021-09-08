package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.CustomerAddressesDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class CustomerAddressValidationServiceImpl implements CustomerAddressValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean customerAddressValidation(
        CustomerAddressesDto customerAddresseDto,
        RedirectAttributes redirectAttributes
    ) {
        boolean returnResult = true;

        if(
            customerAddresseDto.getCustomerId() == null || 
            customerAddresseDto.getAddressId() == null || 
            customerAddresseDto.getAddressTypeCode() == null || 
            customerAddresseDto.getDateFrom() == null || 
            customerAddresseDto.getDateTo() == null || 
            customerAddresseDto.getCustomerId().equalsIgnoreCase("") || 
            customerAddresseDto.getAddressId().equalsIgnoreCase("") || 
            customerAddresseDto.getAddressTypeCode().equalsIgnoreCase("") || 
            customerAddresseDto.getDateFrom().equalsIgnoreCase("") || 
            customerAddresseDto.getDateTo().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field must be contains");
        }else if(
            !validationUtilsService
                .phoneValidation(customerAddresseDto.getCustomerId())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid CustomerId");
        }else if(
            !validationUtilsService
                .phoneValidation(customerAddresseDto.getAddressId())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Address ID");
        }else if(
            !validationUtilsService.checkCustomerId(Long.parseLong(customerAddresseDto.getCustomerId()))
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid CustomerID");
        }else if(
            !validationUtilsService.checkAddressId(Long.parseLong(customerAddresseDto.getAddressId()))
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid AddressID");
        }else if(
            !validationUtilsService.checkAddressTypeCode(customerAddresseDto.getAddressTypeCode())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Address Type Code");
        }else{
            returnResult = false;
        }

        return returnResult;
    }
}
