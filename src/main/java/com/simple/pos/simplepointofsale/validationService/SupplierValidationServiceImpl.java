package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.SuppliersDto;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class SupplierValidationServiceImpl implements SupplierValidationService{

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
        }

        return false;
    }
}
