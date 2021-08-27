package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.service.AddressesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private AddressesService addressesService;

    @GetMapping("/list")
    public String viewAddressTypeMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listAddressType", addressesService.getAllAddresses());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "address_type_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        AddressTypes addressTypes = new AddressTypes();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressTypes", addressTypes);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);

        return "address_type_ui/add_address_type";
    }

    @PostMapping("/save")
    public String save(Model model){
        return null;
    }
}
