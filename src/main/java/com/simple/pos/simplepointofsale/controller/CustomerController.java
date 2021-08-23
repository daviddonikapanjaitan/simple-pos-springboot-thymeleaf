package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.CustomerDto;
import com.simple.pos.simplepointofsale.model.Customer;
import com.simple.pos.simplepointofsale.service.CustomerService;
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
 
@Controller
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
     
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/")
    public String viewCustomerPage(Model model){
        model.addAttribute("listCustomers", customerService.getAllCustomers());
        return "index";
    }
   
    @GetMapping("/addNewCustomer")
    public String addNewCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add_new_customer";
    }

    @PostMapping("/saveCustomer")
    public String createCustomer(
        @ModelAttribute("customer") CustomerDto customerDto
    ) throws ParseException{
        Date dateBecomeCustomer = new SimpleDateFormat("yyyy-MM-dd").parse(customerDto.getDateBecomeCustomer());  

        customerService.saveCustomer(new Customer(
            customerDto.getPaymentMethodCode(),
            customerDto.getCustomerName(),
            customerDto.getCustomerPhone(),
            customerDto.getCustomerEmail(),
            dateBecomeCustomer,
            customerDto.getPaymentDetails(),
            customerDto.getOtherCustomerDetails()
        ));
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String updateCusotmerDate(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        Customer customerDB = customerService.getCustomerById(id);
        String customerDate = converterService.dateToString(customerDB.getDateBecomeCustomer(), "yyyy-MM-dd");

        CustomerDto customerDto = new CustomerDto(
            customerDB.getCustomerName(),
            customerDB.getCustomerPhone(),
            customerDB.getCustomerEmail(),
            customerDate,
            customerDB.getPaymentDetails(),
            customerDB.getOtherCustomerDetails()
        );
        
        logger.info("{}", customerDto);

        model.addAttribute("customerDto", customerDto);

        return "update_customer_data";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(
        @PathVariable(value = "id") long id
    ){
        this.customerService.deleteCustomerById(id);
        return "redirect:/";
    }
}
