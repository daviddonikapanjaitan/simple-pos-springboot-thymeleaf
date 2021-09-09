package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ShoppingBasketDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ShoppingBasketValidationServiceImpl implements ShoppingBasketValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean shoppingBasketValidation(
            ShoppingBasketDto shoppingBasketDto,
            RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            shoppingBasketDto.getCustomerId() == null ||
            shoppingBasketDto.getBasketDateTime() == null ||
            shoppingBasketDto.getTotalCost() == null || 
            shoppingBasketDto.getOtherBasketDetails() == null
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(
            shoppingBasketDto.getOtherBasketDetails().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field Other basket details length must larger than 5");
        }else if(
            !validationUtilsService.checkCustomerId(Long.parseLong(shoppingBasketDto.getCustomerId()))
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Customer ID");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
