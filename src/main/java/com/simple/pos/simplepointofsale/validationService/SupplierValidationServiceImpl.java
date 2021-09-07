package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.SuppliersDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class SupplierValidationServiceImpl implements SupplierValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean supplierValidation(SuppliersDto suppliersDto, 
        RedirectAttributes redirectAttributes) {
        boolean resultReturn = true;

        if(
            suppliersDto.getSupplierCode() == null || 
            suppliersDto.getSupplierName() == null || 
            suppliersDto.getSupplierAddress() == null || 
            suppliersDto.getSupplierEmail() == null || 
            suppliersDto.getSupplierPhone() == null || 
            suppliersDto.getOtherSupplierDetails() == null || 
            suppliersDto.getSupplierCode().equalsIgnoreCase("") ||
            suppliersDto.getSupplierName().equalsIgnoreCase("") ||
            suppliersDto.getSupplierAddress().equalsIgnoreCase("") ||
            suppliersDto.getSupplierEmail().equalsIgnoreCase("") ||
            suppliersDto.getSupplierPhone().equalsIgnoreCase("") ||
            suppliersDto.getOtherSupplierDetails().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field must be contains");
        }else if(
            suppliersDto.getSupplierCode().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else if(
            suppliersDto.getSupplierName().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else if(
            suppliersDto.getSupplierAddress().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else if(
            suppliersDto.getSupplierEmail().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else if(!validationUtilsService.validateEmail(suppliersDto.getSupplierEmail())){
            redirectAttributes.addFlashAttribute("message", "Supplier Email Invalid");
        }else if(
            suppliersDto.getSupplierPhone().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else if(!validationUtilsService.phoneValidation(suppliersDto.getSupplierPhone())){
            redirectAttributes.addFlashAttribute("message", "Customer Phone Invalid");
        }else if(
            suppliersDto.getOtherSupplierDetails().length() < 3
        ){
            redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
