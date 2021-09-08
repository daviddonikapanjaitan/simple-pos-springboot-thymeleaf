package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.InventoryLocationsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class InventoryLocationsValidationImpl implements InventoryLocationsValidation{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean inventoryLocationValidation(InventoryLocationsDto inventoryLocationsDto,
            RedirectAttributes redirectAttributes) {
        boolean resultReturn = true;
        
        if(
            inventoryLocationsDto.getProductId() == null || 
            inventoryLocationsDto.getLocationAddressId() == null ||
            inventoryLocationsDto.getQuantityInStock() == null ||
            inventoryLocationsDto.getReorderLevel() == null ||
            inventoryLocationsDto.getReorderQuantity() == null ||
            inventoryLocationsDto.getTotalAverageMonthlyUsage() == null ||
            inventoryLocationsDto.getOtherInventoryDetails() == null || 
            inventoryLocationsDto.getOtherInventoryDetails().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(inventoryLocationsDto.getOtherInventoryDetails().length() < 5){
            redirectAttributes.addFlashAttribute("message", "Field Other Inventory Details length must larger than 5");
        }else if(!validationUtilsService.checkAddressId(inventoryLocationsDto.getLocationAddressId())){
            redirectAttributes.addFlashAttribute("message", "Location Address ID Invalid");
        }else if(!validationUtilsService.checkProductId(inventoryLocationsDto.getProductId().toString())){
            redirectAttributes.addFlashAttribute("message", "Product ID Invalid");
        }else{
            resultReturn = false;
        }
        
        return resultReturn;
    }
}