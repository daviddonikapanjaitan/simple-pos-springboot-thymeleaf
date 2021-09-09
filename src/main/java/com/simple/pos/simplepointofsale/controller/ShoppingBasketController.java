package com.simple.pos.simplepointofsale.controller;

import java.text.ParseException;
import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.ShoppingBasketDto;
import com.simple.pos.simplepointofsale.model.ShoppingBasket;
import com.simple.pos.simplepointofsale.service.CustomerService;
import com.simple.pos.simplepointofsale.service.ShoppingBasketService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.validationService.ShoppingBasketValidationService;

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
@RequestMapping("/shopping-basket")
public class ShoppingBasketController {
      
    private static Logger logger = LoggerFactory.getLogger(ShoppingBasketController.class);

    private static String titleCRUD = "Shopping Basket";
    private static String shoppingBasketListLink = "shopping-basket/list";
    private static String saveShoppingBasketFormLink = "shopping-basket/add-basket-shopping-form";
    private static String updateFormLink = "shopping-basket/update-form";
    private static String deleteFormLink = "shopping-basket/delete";
    private static String postSaveLink = "shopping-basket/save-shopping-basket";

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    ShoppingBasketValidationService shoppingBasketValidationService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String viewShoppingBasketPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listShoppingBasket", shoppingBasketService.getAllShoppingBaskets());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveShoppingBasketFormLink", saveShoppingBasketFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "shopping_basket_ui/index";
    }

    @GetMapping("/add-basket-shopping-form")
    public String basketShoppingForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        model.addAttribute("listCustomer", customerService.getAllCustomers());

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("shoppingBasket", shoppingBasket);
        model.addAttribute("shoppingBasketListLink", shoppingBasketListLink);
        model.addAttribute("postSaveLink", postSaveLink);
        return "shopping_basket_ui/add_shopping_basket";
    }

    @PostMapping("/save-shopping-basket")
    public String saveShoppingBasket(
        @ModelAttribute("shoppingBasket") ShoppingBasketDto shoppingBasketDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectReturn = "redirect:/shopping-basket/list";

        logger.info("{}", shoppingBasketDto.toString());

        Date basketDateTime = converterService.stringToDate(shoppingBasketDto.getBasketDateTime(), "yyyy-MM-dd");

        if(
            !shoppingBasketValidationService
                .shoppingBasketValidation(shoppingBasketDto, redirectAttributes)
        ){
            shoppingBasketService.saveShoppingBasket(
                new ShoppingBasket(
                    shoppingBasketDto.getCustomerId(),
                    basketDateTime,
                    shoppingBasketDto.getTotalCost(),
                    shoppingBasketDto.getOtherBasketDetails()
                )
            );
        }else{
            redirectReturn = "redirect:/shopping-basket/add-basket-shopping-form";
        }

        return redirectReturn;
    }

    @GetMapping("/update-form/{id}")
    public String updateFormShoppingBasket(
        @PathVariable Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        ShoppingBasket shoppingBasket = shoppingBasketService.getShoppingBasketById(id);
        String basketDateTime = converterService.dateToString(shoppingBasket.getBasketDateTime(), "yyyy-MM-dd");

        ShoppingBasketDto shoppingBasketDto = new ShoppingBasketDto(
            shoppingBasket.getCustomerId(),
            basketDateTime,
            shoppingBasket.getTotalCost(),
            shoppingBasket.getOtherBasketDetails()
        );

        model.addAttribute("customer_id", shoppingBasket.getCustomerId());
        model.addAttribute("listCustomer", customerService.getAllCustomers());

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("shoppingBasketListLink", shoppingBasketListLink);
        model.addAttribute("shoppingBasketDto", shoppingBasketDto);
        model.addAttribute("shoppingBasketId", id);

        return "shopping_basket_ui/update_shopping_basket";
    }

    @PostMapping("/update-form/{id}")
    public String updateShoppingBasket(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("ShoppingBasketDto") ShoppingBasketDto shoppingBasketDto,
        RedirectAttributes redirectAttributes
    ) throws ParseException{
        String redirectReturn = "redirect:/shopping-basket/list";

        Date dateShoppingBasket = converterService.stringToDate(shoppingBasketDto.getBasketDateTime(), 
            "yyyy-MM-dd");
        
        ShoppingBasket shoppingBasket = new ShoppingBasket(
            shoppingBasketDto.getCustomerId(),
            dateShoppingBasket,
            shoppingBasketDto.getTotalCost(),
            shoppingBasketDto.getOtherBasketDetails()
        );

        shoppingBasket.setShoppingBasketId(id);

        if(
            !shoppingBasketValidationService
                .shoppingBasketValidation(shoppingBasketDto, redirectAttributes)
        ){
            shoppingBasketService.saveShoppingBasket(shoppingBasket);
        }else{
            redirectReturn = "redirect:/shopping-basket/update-form/" + id;
        }

        return redirectReturn;
    }

    @GetMapping("/delete/{id}")
    public String deleteShoppingBasket(
        @PathVariable(value = "id") Long id
    ){
        this.shoppingBasketService.deleteShoppingBasketById(id);
        return "redirect:/shopping-basket/list";
    }
}
