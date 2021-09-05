package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;

import com.simple.pos.simplepointofsale.Dto.PaymentMethodDto;
import com.simple.pos.simplepointofsale.model.PaymentMethod;
import com.simple.pos.simplepointofsale.service.PaymentMethodService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.validationService.PaymentMethodValidationService;

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
@RequestMapping("/payment-method")
public class PaymentMethodController {
    
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    PaymentMethodValidationService paymentMethodValidationService;

    @GetMapping("/list")
    public String viewPaymentMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("listPaymentMethod", paymentMethodService.getAllPaymentMethod());
        return "paymentmethod_ui/index";
    }

    @GetMapping("/save-payment-method-form")
    public String paymetMethodForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        PaymentMethod paymentMethod = new PaymentMethod();

        model.addAttribute("paymentMethod", paymentMethod);
        return "paymentmethod_ui/add_payment_method";
    }

    @GetMapping("/update-payment-method-form/{id}")
    public String updatePaymetMethodForm(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(id);

        PaymentMethodDto paymentMethodDto = new PaymentMethodDto(
            paymentMethod.getPaymentMethodCode(),
            paymentMethod.getPaymentMethodDescription()
        );
        
        logger.info("{}", paymentMethod.toString());
        logger.info("{}", paymentMethodDto.toString());

        model.addAttribute("paymentMethod", paymentMethodDto);
        model.addAttribute("paymentMethodId", id);
        
        return "paymentmethod_ui/update_payment_method";
    }

    @PostMapping("/updatePaymentMethod/{id}")
    public String updatePaymentMethod(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("paymentMethod") PaymentMethodDto paymentMethodDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/payment-method/list";

        paymentMethodDto.setPaymentMethodId(id);

        PaymentMethod updatePaymentMethod = new PaymentMethod(
            paymentMethodDto.getPaymentMethodCode(),
            paymentMethodDto.getPaymentMethodDescription()
        );

        updatePaymentMethod.setPaymentMethodId(id);

        if(!paymentMethodValidationService.
            paymentMethodValidation(paymentMethodDto, redirectAttributes)){

            paymentMethodService.savePaymentMethod(updatePaymentMethod);
        }else{
            redirectLink = "redirect:/payment-method/update-payment-method-form/" + id;
        }

        return redirectLink;
    }

    @PostMapping("/savePaymentMethod")
    public String createPaymentMethod(
        @ModelAttribute("paymentMethod") PaymentMethodDto paymentMethodDto,
        RedirectAttributes redirectAttributes
    ) throws ParseException{
        String redirectLink = "redirect:/payment-method/list";
        
        logger.info("{}", paymentMethodDto.toString());
        paymentMethodDto.setPaymentMethodId(123L);

        if(!paymentMethodValidationService
            .paymentMethodValidation(paymentMethodDto, redirectAttributes)){

            paymentMethodService.savePaymentMethod(new PaymentMethod(
                paymentMethodDto.getPaymentMethodCode(),
                paymentMethodDto.getPaymentMethodDescription()
            ));
        }else{
            redirectLink = "redirect:/payment-method/save-payment-method-form";
        }

        return redirectLink;
    }

    @GetMapping("/deletePaymentMethod/{id}")
    public String deletePaymentMethod(
        @PathVariable(value = "id") Long id
    ){
        this.paymentMethodService.deletePaymentMethod(id);
        return "redirect:/payment-method/list";
    }
}
