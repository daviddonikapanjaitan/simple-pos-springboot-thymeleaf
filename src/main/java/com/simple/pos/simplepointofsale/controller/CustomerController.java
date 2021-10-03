package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.CustomerDto;
import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;
import com.simple.pos.simplepointofsale.model.Customer;
import com.simple.pos.simplepointofsale.model.PaymentMethod;
import com.simple.pos.simplepointofsale.service.CustomerService;
import com.simple.pos.simplepointofsale.service.PaymentMethodService;
import com.simple.pos.simplepointofsale.service.UserService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.utils.PaginationService;
import com.simple.pos.simplepointofsale.validationService.CustomerValidationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
     
    private static String listLink = "";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    UserService userService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    PaymentMethodService paymentMethodService;

    @Autowired
    CustomerValidationService customerValidationService;

    @Autowired
    PaginationService paginationService;

    @GetMapping("/")
    public String viewCustomerPage(Model model, 
        @RequestParam(defaultValue = "ascDesc") String ascDesc,
        @RequestParam(defaultValue = "page") String page,
        @RequestParam(defaultValue = "size") String size,
        @RequestParam(defaultValue = "filtering") String filtering){
        PaginationRequestDto paginationRequestDto = new PaginationRequestDto(
            ascDesc,
            page,
            size,
            filtering,
            customerService.getSize(),
            "customerId"
        );
        PaginationDto paginationDto = paginationService
            .paginationService(paginationRequestDto);

        Pageable pageable = paginationDto.getPageable();
        Integer pageList = paginationDto.getPageList();
        Integer nextPageList = paginationDto.getNextPageList();
        Integer totalPage = paginationDto.getTotalPage();

        List<Customer> lCustomers = new ArrayList<>();
        lCustomers = customerService.getAllCustomersAscDesc(pageable);
        List<Customer> lCustomersFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(Customer customer : lCustomers){
                if(customer.getCustomerId() == Long.parseLong(filtering)){
                    lCustomersFiltering.add(customer);
                }
            }
            lCustomers = lCustomersFiltering;
        }else{
            filtering = "";
        }

        if(userService.checkRole("ROLE_USER")){
            logger.info("ROLE_USESR");
        }

        addAttributeService.addFirstNameAttribute(model);

        model.addAttribute("listCustomers", lCustomers);
        model.addAttribute("refresh", listLink);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("ascDesc", ascDesc);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("filtering", filtering);
        model.addAttribute("pageList", pageList);
        model.addAttribute("nextPageList", nextPageList);
        return "customers_ui/index";
    }
   
    @GetMapping("/addNewCustomer")
    public String addNewCustomer(Model model){
        List<PaymentMethod> listPaymentMethod = paymentMethodService.getAllPaymentMethod();

        addAttributeService.addFirstNameAttribute(model);

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("listPaymentMethod", listPaymentMethod);
        return "customers_ui/add_new_customer";
    }

    @PostMapping("/saveCustomer")
    public String createCustomer(
        @ModelAttribute("customer") CustomerDto customerDto,
        RedirectAttributes redirectAttributes
    ) throws ParseException{
        String returnRedirect = "redirect:/";
        
        Date dateBecomeCustomer = converterService.stringToDate(customerDto.getDateBecomeCustomer(), "yyyy-MM-dd");

        if(!customerValidationService
            .customerValidation(customerDto, redirectAttributes)){
                customerService.saveCustomer(new Customer(
                    customerDto.getPaymentMethodCode(),
                    customerDto.getCustomerName(),
                    customerDto.getCustomerPhone(),
                    customerDto.getCustomerEmail(),
                    dateBecomeCustomer,
                    customerDto.getPaymentDetails(),
                    customerDto.getOtherCustomerDetails()
                ));
        }else{
            returnRedirect = "redirect:/addNewCustomer";
        }
        
        return returnRedirect;
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCusotmerId(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("customer") CustomerDto customerDto,
        RedirectAttributes redirectAttributes
    ) throws ParseException{
        String returnRedirect = "redirect:/";

        Date dateBecomeCustomer = new SimpleDateFormat("yyyy-MM-dd").parse(customerDto.getDateBecomeCustomer());

        Customer updateCustomer = new Customer(
            customerDto.getPaymentMethodCode(),
            customerDto.getCustomerName(),
            customerDto.getCustomerPhone(),
            customerDto.getCustomerEmail(),
            dateBecomeCustomer,
            customerDto.getPaymentDetails(),
            customerDto.getOtherCustomerDetails()
        );

        updateCustomer.setCustomerId(id);

        if(!customerValidationService
            .customerValidation(customerDto, redirectAttributes)){
                customerService.saveCustomer(updateCustomer);
        }else{
            returnRedirect = "redirect:/showFormForUpdate/" + id;
        }

        return returnRedirect;
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String updateCusotmerDate(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        List<PaymentMethod> listPaymentMethod = paymentMethodService.getAllPaymentMethod();

        addAttributeService.addFirstNameAttribute(model);
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

        model.addAttribute("payment_code", customerDB.getPaymentMethodCode());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerId", id);
        model.addAttribute("listPaymentMethod", listPaymentMethod);

        return "customers_ui/update_customer_data";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(
        @PathVariable(value = "id") long id
    ){
        this.customerService.deleteCustomerById(id);
        return "redirect:/";
    }
}
