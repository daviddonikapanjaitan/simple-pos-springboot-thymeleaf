package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ProductsValidationServiceImpl implements ProductsValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean productsValidation(
        ProductsDto productsDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            productsDto.getProductTypeCode() == null ||
            productsDto.getProductDetails() == null ||
            productsDto.getProductName() == null ||
            productsDto.getProductPrice() == null ||
            productsDto.getProductDescription() == null ||
            productsDto.getProductTypeCode().equalsIgnoreCase("") || 
            productsDto.getProductDetails().equalsIgnoreCase("") || 
            productsDto.getProductName().equalsIgnoreCase("") || 
            productsDto.getProductPrice().toString().equalsIgnoreCase("") || 
            productsDto.getProductDescription().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(!validationUtilsService.phoneValidation(productsDto.getProductPrice().toString())){
            redirectAttributes.addFlashAttribute("message", "Invalid Price");
        }else if(!validationUtilsService.checkProductTypes(productsDto.getProductTypeCode())){
            redirectAttributes.addFlashAttribute("message", "Invalid Product Type Code");
        }else if(productsDto.getProductTypeCode().length() < 1){
            redirectAttributes.addFlashAttribute("message", "Field Product Type Code length must larger than 2");
        }else if(productsDto.getProductDetails().length() < 5){
            redirectAttributes.addFlashAttribute("message", "Field Product Details length must larger than 4");
        }else if(productsDto.getProductName().length() < 5){
            redirectAttributes.addFlashAttribute("message", "Field Product Name length must larger than 4");
        }else if(productsDto.getProductDescription().length() < 5){
            redirectAttributes.addFlashAttribute("message", "Field Product Description length must larger than 4");
        }else{
            resultReturn = false;
        }
        
        return resultReturn;
    }
}
