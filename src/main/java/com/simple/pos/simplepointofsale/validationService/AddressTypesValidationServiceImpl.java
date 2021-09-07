package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.AddressTypesDto;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class AddressTypesValidationServiceImpl implements AddressTypesValidationService{

    @Override
    public boolean addressTypesValidation(
        AddressTypesDto addressTypesDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;
        
        if(
            addressTypesDto.getAddressTypeCode() == null || 
            addressTypesDto.getAddressTypeDescription() == null || 
            addressTypesDto.getAddressTypeCode().equalsIgnoreCase("") || 
            addressTypesDto.getAddressTypeDescription().equalsIgnoreCase("")
        ){
            redirectAttributes
                .addFlashAttribute("message", "Field Must be contains");
        }else if(
            addressTypesDto.getAddressTypeCode().length() < 3
        ){
            redirectAttributes
                .addFlashAttribute("message", "Address Type code lenght must larger than 5");
        }else if(
            addressTypesDto.getAddressTypeDescription().length() < 5
        ){
            redirectAttributes
                .addFlashAttribute("message", "Address Type Description lenght must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}