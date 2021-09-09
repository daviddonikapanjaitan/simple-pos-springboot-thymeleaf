package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.BasketItemsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class BasketItemsValidationServiceImpl implements BasketItemsValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean basketItemsValidation(
        BasketItemsDto basketItemsDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean redirectReturn = true;
        
        if(
            basketItemsDto.getCustomerId() == null || 
            basketItemsDto.getBasketDateTime() == null || 
            basketItemsDto.getProductId() == null || 
            basketItemsDto.getQuantity() == null || 
            basketItemsDto.getCost() == null
        ){
            redirectAttributes
                .addFlashAttribute("message", "Field Must be contains");
        }else if(
            !validationUtilsService
                .checkCustomerId(basketItemsDto.getCustomerId())
        ){
            redirectAttributes
                .addFlashAttribute("message", "Invalid Customer ID");
        }else if(
            !validationUtilsService
                .checkProductId(basketItemsDto.getProductId().toString())
        ){
            redirectAttributes
                .addFlashAttribute("message", "Invalid Product ID");
        }else {
            redirectReturn = false;
        }

        return redirectReturn;
    }
}
