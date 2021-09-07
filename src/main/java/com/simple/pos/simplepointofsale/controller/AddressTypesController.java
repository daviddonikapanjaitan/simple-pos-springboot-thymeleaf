package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.AddressTypesDto;
import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.service.AddressTypesService;
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
@RequestMapping("/address-type")
public class AddressTypesController {
    
    private static Logger logger = LoggerFactory.getLogger(AddressTypes.class);

    private static String titleCRUD = "AddressTypes";
    private static String listLink = "address-type/list";
    private static String saveFormLink = "address-type/add-form";
    private static String updateFormLink = "address-type/update-form";
    private static String deleteFormLink = "address-type/delete";
    private static String postSaveLink = "address-type/save";

    @Autowired
    private AddressTypesService addressTypesService;

    @Autowired
    AddAttributeService addAttributeService;

    @GetMapping("/list")
    public String viewAddressTypeMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);

        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listAddressType", addressTypesService.getAllAddressTypes());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "address_type_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        AddressTypes addressTypes = new AddressTypes();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressTypes", addressTypes);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);

        return "address_type_ui/add_address_type";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("addressTypes") AddressTypesDto addressTypesDto
    ){
        logger.info("{}", addressTypesDto.toString());

        addressTypesService.saveAddressTypes(new AddressTypes(
            addressTypesDto.getAddressTypeCode(),
            addressTypesDto.getAddressTypeDescription()
        ));

        return "redirect:/address-type/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateFormAddressTypes(
        @PathVariable Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        AddressTypes addressTypes = addressTypesService.getAddressTypesById(id);

        AddressTypesDto addressTypesDto = new AddressTypesDto(
            addressTypes.getAddressTypeCode(),
            addressTypes.getAddressTypeDescription()
        );

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("listLink", listLink);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressTypesDto", addressTypesDto);
        model.addAttribute("addressTypesId", id);

        return "address_type_ui/update_address_type";
    }

    @PostMapping("/update-form/{id}")
    public String updateAddressTypes(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("addressTypes") AddressTypesDto addressTypesDto
    ){
        AddressTypes addressTypes = new AddressTypes(
            addressTypesDto.getAddressTypeCode(),
            addressTypesDto.getAddressTypeDescription()
        );

        addressTypes.setAddressTypeId(id);

        addressTypesService.saveAddressTypes(addressTypes);

        return "redirect:/address-type/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdderssTypes(
        @PathVariable(value = "id") Long id
    ){
        this.addressTypesService.deleteAddressTypesById(id);
        return "redirect:/address-type/list";
    }
}
