package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.BasketItemsDto;
import com.simple.pos.simplepointofsale.model.BasketItems;
import com.simple.pos.simplepointofsale.service.BasketItemsService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
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
@RequestMapping("/basket-items")
public class BasketItemsController {
    
    private static Logger logger = LoggerFactory.getLogger(BasketItemsController.class);

    private static String titleCRUD = "Basket Items";
    private static String listLink = "basket-items/list";
    private static String saveFormLink = "basket-items/add-form";
    private static String updateFormLink = "basket-items/update-form";
    private static String deleteFormLink = "basket-items/delete";
    private static String postSaveLink = "basket-items/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private BasketItemsService basketItemsService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    AddAttributeService addAttributeService;

    @GetMapping("/list")
    public String viewBasketItemsMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);

        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listBasketItems", basketItemsService.getAllBasketItems());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);

        return "basket_items_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        BasketItems basketItems = new BasketItems();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "basket_items_ui/add_basket_items";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("basketItems") BasketItemsDto basketItemsDto
    ){
        logger.info("{}", basketItemsDto.toString());
    
        Date basketDateTime = converterService.stringToDate(basketItemsDto.getBasketDateTime(), "yyyy-MM-dd");

        basketItemsService.saveBasketItems(new BasketItems(
            basketItemsDto.getCustomerId(),
            basketDateTime,
            basketItemsDto.getProductId(),
            basketItemsDto.getQuantity(),
            basketItemsDto.getCost()
        ));

        return "redirect:/basket-items/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateBasketItemsForm(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        BasketItems basketItems = basketItemsService.getBasketItemsById(id);
        String basketDateTime = converterService.dateToString(basketItems.getBasketDateTime(), "yyyy-MM-dd");

        BasketItemsDto basketItemsDto = new BasketItemsDto(
            basketItems.getCustomerId(),
            basketDateTime,
            basketItems.getProductId(),
            basketItems.getQuantity(),
            basketItems.getCost()
        );

        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("basketItemsDto", basketItemsDto);
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("saveOrUpdate", updatePage);

        return "basket_items_ui/update_basket_items";
    }

    @PostMapping("/update-form/{id}")
    public String updateBasketItems(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("basketItems") BasketItemsDto basketItemsDto
    ){
        Date basketDateTime = converterService.stringToDate(basketItemsDto.getBasketDateTime(), "yyyy-MM-dd");

        BasketItems basketItems = new BasketItems(
            basketItemsDto.getCustomerId(),
            basketDateTime,
            basketItemsDto.getProductId(),
            basketItemsDto.getQuantity(),
            basketItemsDto.getCost()
        );

        basketItems.setBasketItemsId(id);

        basketItemsService.saveBasketItems(basketItems);

        return "redirect:/basket-items/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(
        @PathVariable(value = "id") Long id
    ){
        basketItemsService.deleteBasketItemsById(id);
        return "redirect:/basket-items/list";
    }
}
