package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.model.Addresses;
import com.simple.pos.simplepointofsale.service.AddressesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public String viewAddressMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listAddresses", addressesService.getAllAddresses());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "addresses_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        Addresses addresses = new Addresses();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addresses", addresses);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        
        return "addresses_ui/add_addresses";
    }
}
