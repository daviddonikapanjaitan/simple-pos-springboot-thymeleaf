package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.AddressesDto;
import com.simple.pos.simplepointofsale.model.Addresses;
import com.simple.pos.simplepointofsale.service.AddressesService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
   
@Controller
@RequestMapping("/addresses")
public class AddressesController {
    
    private static Logger logger = LoggerFactory.getLogger(AddressesController.class);
    
    private static String titleCRUD = "Addresses";
    private static String listLink = "addresses/list";
    private static String saveFormLink = "addresses/add-form";
    private static String updateFormLink = "addresses/update-form";
    private static String deleteFormLink = "addresses/delete";
    private static String postSaveLink = "addresses/save";

    @Autowired
    private AddressesService addressesService;

    @Autowired
    AddAttributeService addAttributeService;

    @GetMapping("/list")
    public String viewAddressMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);

        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listAddresses", addressesService.getAllAddresses());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "addresses_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        Addresses addresses = new Addresses();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addresses", addresses);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        
        return "addresses_ui/add_addresses";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("addresses") AddressesDto addressesDto
    ){
        logger.info("{}", addressesDto.toString());

        addressesService.saveAddresses(new Addresses(
            addressesDto.getLine1(),
            addressesDto.getLine2(),
            addressesDto.getLine3(),
            addressesDto.getLine4(),
            addressesDto.getCity(),
            addressesDto.getZipPostcode(),
            addressesDto.getStateProvinceCounty(),
            addressesDto.getCountry(),
            addressesDto.getOtherAddressDetails()
        ));

        return "redirect:/addresses/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateFormAddresses(
        @PathVariable Long id,
        Model model
    ){
        Addresses addresses = addressesService.getAddressesById(id);
        addAttributeService.addFirstNameAttribute(model);

        AddressesDto addressesDto = new AddressesDto(
            addresses.getLine1(),
            addresses.getLine2(),
            addresses.getLine3(),
            addresses.getLine4(),
            addresses.getCity(),
            addresses.getZipPostcode(),
            addresses.getStateProvinceCounty(),
            addresses.getCountry(),
            addresses.getOtherAddressDetails()
        );

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("listLink", listLink);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressesDto", addressesDto);
        model.addAttribute("addressesId", id);

        return "addresses_ui/update_addresses";
    }

    @PostMapping("/update-form/{id}")
    public String updateAddress(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("addresses") AddressesDto addressesDto
    ){
        Addresses addresses = new Addresses(
            addressesDto.getLine1(),
            addressesDto.getLine2(),
            addressesDto.getLine3(),
            addressesDto.getLine4(),
            addressesDto.getCity(),
            addressesDto.getZipPostcode(),
            addressesDto.getStateProvinceCounty(),
            addressesDto.getCountry(),
            addressesDto.getOtherAddressDetails()
        );

        addresses.setAddressId(id);

        addressesService.saveAddresses(addresses);

        return "redirect:/addresses/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddresses(
        @PathVariable(value = "id") Long id
    ){
        this.addressesService.deleteAddressesById(id);
        return "redirect:/addresses/list";
    }
}
