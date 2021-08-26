package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.ShoppingBasketDto;
import com.simple.pos.simplepointofsale.model.ShoppingBasket;
import com.simple.pos.simplepointofsale.service.ShoppingBasketService;
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
@RequestMapping("/shopping-basket")
public class ShoppingBasketController {
      
    private static Logger logger = LoggerFactory.getLogger(ShoppingBasketController.class);

    private static String titleCRUD = "Shopping Basket";
    private static String shoppingBasketListLink = "shopping-basket/list";
    private static String saveShoppingBasketFormLink = "shopping-basket/add-basket-shopping-form";
    private static String postSaveLink = "shopping-basket/save-shopping-basket";

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/list")
    public String viewShoppingBasketPage(Model model){
        model.addAttribute("listShoppingBasket", shoppingBasketService.getAllShoppingBaskets());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveShoppingBasketFormLink", saveShoppingBasketFormLink);
        return "shopping_basket_ui/index";
    }

    @GetMapping("/add-basket-shopping-form")
    public String basketShoppingForm(Model model){
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("shoppingBasket", shoppingBasket);
        model.addAttribute("shoppingBasketListLink", shoppingBasketListLink);
        model.addAttribute("postSaveLink", postSaveLink);
        return "shopping_basket_ui/add_shopping_basket";
    }

    @PostMapping("/save-shopping-basket")
    public String saveShoppingBasket(
        @ModelAttribute("shoppingBasket") ShoppingBasketDto shoppingBasketDto
    ){
        logger.info("{}", shoppingBasketDto.toString());

        Date basketDateTime = converterService.stringToDate(shoppingBasketDto.getBasketDateTime(), "yyyy-MM-dd");

        shoppingBasketService.saveShoppingBasket(
            new ShoppingBasket(
                shoppingBasketDto.getCustomerId(),
                basketDateTime,
                shoppingBasketDto.getTotalCost(),
                shoppingBasketDto.getOtherBasketDetails()
            )
        );

        return "redirect:/shopping-basket/list";
    }
}
