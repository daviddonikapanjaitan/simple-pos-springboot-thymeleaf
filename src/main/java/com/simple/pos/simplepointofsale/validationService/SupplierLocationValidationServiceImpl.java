package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.SupplierLocationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class SupplierLocationValidationServiceImpl implements SupplierLocationValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean supplierLocationValidation(
        SupplierLocationDto supplierLocationDto,
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            supplierLocationDto.getSupplierCode() == null ||
            supplierLocationDto.getAddressId() == null ||
            supplierLocationDto.getDateFrom() == null ||
            supplierLocationDto.getDateTo() == null || 
            supplierLocationDto.getSupplierCode().equalsIgnoreCase("") || 
            supplierLocationDto.getAddressId().equalsIgnoreCase("") || 
            supplierLocationDto.getDateFrom().equalsIgnoreCase("") || 
            supplierLocationDto.getDateTo().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }else if(
            !validationUtilsService.checkSupplierCode(supplierLocationDto.getSupplierCode())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Supplier Code");
        }else if(
            !validationUtilsService.checkAddressId(Long.parseLong(supplierLocationDto.getAddressId()))
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Address Id");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
