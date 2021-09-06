package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductTypesDto;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Service
public class ProductTypesServiceValidationImpl implements ProductTypesServiceValidation{

    @Override
    public boolean productTypesValidation(
        ProductTypesDto productTypesDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            productTypesDto.getProductTypeCode() == null || 
            productTypesDto.getProductTypeDescription() == null ||
            productTypesDto.getProductTypeCode().equalsIgnoreCase("") || 
            productTypesDto.getProductTypeDescription().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field must be contains");
        }else if(
            productTypesDto.getProductTypeCode().length() < 2
        ){
            redirectAttributes.addFlashAttribute("message", "Field product types code length must larger than 5");
        }else if(
            productTypesDto.getProductTypeDescription().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field product types description length must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
