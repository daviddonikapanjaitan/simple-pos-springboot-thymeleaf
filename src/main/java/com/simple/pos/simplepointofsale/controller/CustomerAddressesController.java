package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.CustomerAddressesDto;
import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.model.Addresses;
import com.simple.pos.simplepointofsale.model.Customer;
import com.simple.pos.simplepointofsale.model.CustomerAddresses;
import com.simple.pos.simplepointofsale.service.AddressTypesService;
import com.simple.pos.simplepointofsale.service.AddressesService;
import com.simple.pos.simplepointofsale.service.CustomerAddressService;
import com.simple.pos.simplepointofsale.service.CustomerService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.validationService.CustomerAddressValidationService;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
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

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    CustomerAddressValidationService customerAddressValidationService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressesService addressesService;

    @Autowired
    AddressTypesService addressTypesService;

    @GetMapping("/list")
    public String viewCUstomerAddressMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listCustomerAddress", customerAddressService.getAllCustomersAddress());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "customer_address_ui/list";
    }
 
    @GetMapping("/add-form")
    public String addForm(Model model){
        List<Customer> lCustomers = customerService.getAllCustomers();
        List<Addresses> lAddresses = addressesService.getAllAddresses();
        List<AddressTypes> lTypes = addressTypesService.getAllAddressTypes();

        addAttributeService.addFirstNameAttribute(model);
        CustomerAddresses customerAddresses = new CustomerAddresses();

        model.addAttribute("listCustomers", lCustomers);
        model.addAttribute("listAddress", lAddresses);
        model.addAttribute("listAddressTypes", lTypes);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("customerAddresses", customerAddresses);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);

        return "customer_address_ui/add_customer_address";
    }
    
    @PostMapping("/save")
    public String save(
        @ModelAttribute("customerAddresses") CustomerAddressesDto customerAddressesDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/customer-addresses/list";
        logger.info("{}", customerAddressesDto.toString());

        Date dateFrom = converterService.stringToDate(customerAddressesDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(customerAddressesDto.getDateTo(), "yyyy-MM-dd");

        if(!customerAddressValidationService
            .customerAddressValidation(
                customerAddressesDto, redirectAttributes)){
            customerAddressService.saveCustomerAddress(new CustomerAddresses(
                Long.parseLong(customerAddressesDto.getCustomerId()),
                Long.parseLong(customerAddressesDto.getAddressId()),
                customerAddressesDto.getAddressTypeCode(),
                dateFrom,
                dateTo
            ));
        }else{
            returnRedirect = "redirect:/customer-addresses/add-form";
        }

        return returnRedirect;
    }
  
    @GetMapping("/update-form/{id}")
    public String updateFormCustomerAddress(
        @PathVariable Long id,
        Model model
    ){
        List<Customer> lCustomers = customerService.getAllCustomers();
        List<Addresses> lAddresses = addressesService.getAllAddresses();
        List<AddressTypes> lTypes = addressTypesService.getAllAddressTypes();

        addAttributeService.addFirstNameAttribute(model);
        CustomerAddresses customerAddresses = customerAddressService.getCustomerAddressById(id);

        String dateFrom = converterService.dateToString(customerAddresses.getDateFrom(), "yyyy-MM-dd");
        String dateTo = converterService.dateToString(customerAddresses.getDateTo(), "yyyy-MM-dd");

        CustomerAddressesDto customerAddressesDto = new CustomerAddressesDto(
            customerAddresses.getCustomerId().toString(),
            customerAddresses.getAddressId().toString(),
            customerAddresses.getAddressTypeCode(),
            dateFrom,
            dateTo
        );

        model.addAttribute("address_id", customerAddresses.getAddressId());
        model.addAttribute("customer_id", customerAddresses.getCustomerId());
        model.addAttribute("listCustomers", lCustomers);
        model.addAttribute("listAddress", lAddresses);
        model.addAttribute("listAddressTypes", lTypes);
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
            Long.parseLong(customerAddressesDto.getCustomerId()),
            Long.parseLong(customerAddressesDto.getAddressId()),
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
