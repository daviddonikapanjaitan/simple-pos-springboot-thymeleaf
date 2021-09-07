package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.AddressesDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class AddressesValidationServiceImpl implements AddressesValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean addressesValidation(
        AddressesDto addressesDto, 
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            addressesDto.getLine1() == null ||
            addressesDto.getLine2() == null ||
            addressesDto.getLine3() == null ||
            addressesDto.getLine3() == null ||
            addressesDto.getLine4() == null ||
            addressesDto.getCity() == null ||
            addressesDto.getZipPostcode() == null ||
            addressesDto.getStateProvinceCounty() == null ||
            addressesDto.getCountry() == null ||
            addressesDto.getOtherAddressDetails() == null || 
            addressesDto.getLine1().equalsIgnoreCase("") ||
            addressesDto.getLine2().equalsIgnoreCase("") ||
            addressesDto.getLine3().equalsIgnoreCase("") ||
            addressesDto.getLine3().equalsIgnoreCase("") ||
            addressesDto.getLine4().equalsIgnoreCase("") ||
            addressesDto.getCity().equalsIgnoreCase("") ||
            addressesDto.getZipPostcode().equalsIgnoreCase("") ||
            addressesDto.getStateProvinceCounty().equalsIgnoreCase("") ||
            addressesDto.getCountry().equalsIgnoreCase("") ||
            addressesDto.getOtherAddressDetails().equalsIgnoreCase("")
        ){
            redirectAttributes
                .addFlashAttribute("message", "Field Must be contains");
        }else if(addressesDto.getLine1().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Line1 length must larger than 5");
        }else if(addressesDto.getLine2().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Line2 length must larger than 5");
        }else if(addressesDto.getLine3().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Line3 length must larger than 5");
        }else if(addressesDto.getLine4().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Line4 length must larger than 5");
        }else if(addressesDto.getCity().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field City length must larger than 5");
        }else if(addressesDto.getZipPostcode().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field ZipPostCode length must larger than 5");
        }else if(!validationUtilsService.phoneValidation(addressesDto.getZipPostcode())){
            redirectAttributes
            .addFlashAttribute("message", "Zip postcode invalid");
        }else if(addressesDto.getStateProvinceCounty().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field State Province County length must larger than 5");
        }else if(addressesDto.getCountry().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Country length must larger than 5");
        }else if(addressesDto.getOtherAddressDetails().length() < 5){
            redirectAttributes
                .addFlashAttribute("message", "Field Other address details length must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
