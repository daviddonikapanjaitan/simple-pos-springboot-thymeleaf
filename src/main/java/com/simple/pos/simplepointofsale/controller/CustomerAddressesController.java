package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.CustomerAddressesDto;
import com.simple.pos.simplepointofsale.model.CustomerAddresses;
import com.simple.pos.simplepointofsale.service.CustomerAddressService;
import com.simple.pos.simplepointofsale.utils.ConverterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/customer-addresses")
public class CustomerAddressesController {
    
    private static Logger logger = LoggerFactory.getLogger(CustomerAddressesController.class);

    private static String titleCRUD = "Customer Addresses";
    private static String listLink = "customer-addresses/list";
    private static String saveFormLink = "customer-addresses/add-form";
    private static String updateFormLink = "customer-addresses/update-form";
    private static String deleteFormLink = "customer-addresses/delete";
    private static String postSaveLink = "customer-addresses/save";

    @Autowired
    private CustomerAddressService customerAddressService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/list")
    public String viewCUstomerAddressMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listCustomerAddress", customerAddressService.getAllCustomersAddress());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "customer_address_ui/list";
    }
 
    @GetMapping("/add-form")
    public String addForm(Model model){
        CustomerAddresses customerAddresses = new CustomerAddresses();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("customerAddresses", customerAddresses);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);

        return "customer_address_ui/add_customer_address";
    }
    
    @PostMapping("/save")
    public String save(
        @ModelAttribute("customerAddresses") CustomerAddressesDto customerAddressesDto
    ){
        logger.info("{}", customerAddressesDto.toString());

        Date dateFrom = converterService.stringToDate(customerAddressesDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(customerAddressesDto.getDateTo(), "yyyy-MM-dd");

        customerAddressService.saveCustomerAddress(new CustomerAddresses(
            customerAddressesDto.getCustomerId(),
            customerAddressesDto.getAddressId(),
            customerAddressesDto.getAddressTypeCode(),
            dateFrom,
            dateTo
        ));

        return "redirect:/customer-addresses/list";
    }
}
