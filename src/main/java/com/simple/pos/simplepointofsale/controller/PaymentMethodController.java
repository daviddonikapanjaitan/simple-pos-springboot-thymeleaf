package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;

import com.simple.pos.simplepointofsale.Dto.PaymentMethodDto;
import com.simple.pos.simplepointofsale.model.PaymentMethod;
import com.simple.pos.simplepointofsale.service.PaymentMethodService;

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
@RequestMapping("/payment-method")
public class PaymentMethodController {
    
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/list")
    public String viewPaymentMethodPage(Model model){
        model.addAttribute("listPaymentMethod", paymentMethodService.getAllPaymentMethod());
        return "paymentmethod_ui/index";
    }

    @GetMapping("/save-payment-method-form")
    public String paymetMethodForm(Model model){
        PaymentMethod paymentMethod = new PaymentMethod();
        model.addAttribute("paymentMethod", paymentMethod);
        return "paymentmethod_ui/add_payment_method";
    }

    @PostMapping("/savePaymentMethod")
    public String createPaymentMethod(
        @ModelAttribute("paymentMethod") PaymentMethodDto paymentMethodDto
    ) throws ParseException{
        
        logger.info("{}", paymentMethodDto.toString());
        
        paymentMethodService.savePaymentMethod(new PaymentMethod(
            paymentMethodDto.getPaymentMethodCode(),
            paymentMethodDto.getPaymentMethodDescription()
        ));

        return "redirect:/payment-method/list";
    }
}
