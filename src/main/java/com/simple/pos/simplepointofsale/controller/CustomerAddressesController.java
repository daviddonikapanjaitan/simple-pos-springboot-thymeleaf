package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.PathVariable;
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
  
    @GetMapping("/update-form/{id}")
    public String updateFormCustomerAddress(
        @PathVariable Long id,
        Model model
    ){
        CustomerAddresses customerAddresses = customerAddressService.getCustomerAddressById(id);

        String dateFrom = converterService.dateToString(customerAddresses.getDateFrom(), "yyyy-MM-dd");
        String dateTo = converterService.dateToString(customerAddresses.getDateTo(), "yyyy-MM-dd");

        CustomerAddressesDto customerAddressesDto = new CustomerAddressesDto(
            customerAddresses.getCustomerId(),
            customerAddresses.getAddressId(),
            customerAddresses.getAddressTypeCode(),
            dateFrom,
            dateTo
        );

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("listLink", listLink);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("customerAddressesDto", customerAddressesDto);
        model.addAttribute("customerAddressesId", id);

        return "customer_address_ui/update_customer_addresses";
    }

    @PostMapping("/update-form/{id}")
    public String updateCustomerAddress(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("customerAddressDto") CustomerAddressesDto customerAddressesDto
    ) throws ParseException{
        
        Date dateFrom = converterService.stringToDate(customerAddressesDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(customerAddressesDto.getDateTo(), "yyyy-MM-dd");

        CustomerAddresses customerAddresses = new CustomerAddresses(
            customerAddressesDto.getCustomerId(),
            customerAddressesDto.getAddressId(),
            customerAddressesDto.getAddressTypeCode(),
            dateFrom,
            dateTo
        );

        customerAddresses.setCustomerAddressId(id);

        customerAddressService.saveCustomerAddress(customerAddresses);

        return "redirect:/customer-addresses/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerAddress(
        @PathVariable(value = "id") Long id
    ){
        this.customerAddressService.deleteCustomerAddressById(id);
        return "redirect:/customer-addresses/list";
    }
}
