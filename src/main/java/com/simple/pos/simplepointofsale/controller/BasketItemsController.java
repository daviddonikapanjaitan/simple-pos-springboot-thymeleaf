package com.simple.pos.simplepointofsale.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.BasketItemsDto;
import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;
import com.simple.pos.simplepointofsale.model.BasketItems;
import com.simple.pos.simplepointofsale.service.BasketItemsService;
import com.simple.pos.simplepointofsale.service.CustomerService;
import com.simple.pos.simplepointofsale.service.ProductsService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.utils.PaginationService;
import com.simple.pos.simplepointofsale.validationService.BasketItemsValidationService;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
   
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

    @Autowired
    BasketItemsValidationService basketItemsValidationService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductsService productsService;

    @Autowired
    PaginationService paginationService;

    @GetMapping("/list")
    public String viewBasketItemsMethodPage(Model model,
        @RequestParam(defaultValue = "ascDesc") String ascDesc,
        @RequestParam(defaultValue = "page") String page,
        @RequestParam(defaultValue = "size") String size,
        @RequestParam(defaultValue = "filtering") String filtering
    ){
        PaginationRequestDto paginationRequestDto = new PaginationRequestDto(
            ascDesc,
            page,
            size,
            filtering,
            basketItemsService.getSize(),
            "basketItemsId"
        );
        PaginationDto paginationDto = paginationService
            .paginationService(paginationRequestDto);

        Pageable pageable = paginationDto.getPageable();
        Integer pageList = paginationDto.getPageList();
        Integer nextPageList = paginationDto.getNextPageList();
        Integer totalPage = paginationDto.getTotalPage();

        List<BasketItems> lBasketItems = new ArrayList<>();
        lBasketItems = basketItemsService.getAllBasketItemsAscDesc(pageable);
        List<BasketItems> lBasketItemsFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(BasketItems basketItems: lBasketItems){
                if(basketItems.getBasketItemsId() == Long.parseLong(filtering)){
                    lBasketItemsFiltering.add(basketItems);
                }
            }
            lBasketItems = lBasketItemsFiltering;
        }else{
            filtering = "";
        }

        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listBasketItems", lBasketItems);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        model.addAttribute("refresh", listLink);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("ascDesc", ascDesc);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("filtering", filtering);
        model.addAttribute("pageList", pageList);
        model.addAttribute("nextPageList", nextPageList);

        return "basket_items_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        BasketItems basketItems = new BasketItems();

        model.addAttribute("listCustomer", customerService.getAllCustomers());
        model.addAttribute("listProduct", productsService.getAllProduct());

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "basket_items_ui/add_basket_items";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("basketItems") BasketItemsDto basketItemsDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/basket-items/list";
        logger.info("{}", basketItemsDto.toString());
    
        Date basketDateTime = converterService.stringToDate(basketItemsDto.getBasketDateTime(), "yyyy-MM-dd");

        if(!basketItemsValidationService
            .basketItemsValidation(basketItemsDto, redirectAttributes)){
            basketItemsService.saveBasketItems(new BasketItems(
                basketItemsDto.getCustomerId(),
                basketDateTime,
                basketItemsDto.getProductId(),
                basketItemsDto.getQuantity(),
                basketItemsDto.getCost()
            ));
        }else{
            returnRedirect = "redirect:/basket-items/add-form";
        }

        return returnRedirect;
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

        model.addAttribute("customer_id", basketItems.getCustomerId());
        model.addAttribute("product_id", basketItems.getProductId());
        model.addAttribute("listCustomer", customerService.getAllCustomers());
        model.addAttribute("listProduct", productsService.getAllProduct());

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
        @ModelAttribute("basketItems") BasketItemsDto basketItemsDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/basket-items/list";
        Date basketDateTime = converterService.stringToDate(basketItemsDto.getBasketDateTime(), "yyyy-MM-dd");

        BasketItems basketItems = new BasketItems(
            basketItemsDto.getCustomerId(),
            basketDateTime,
            basketItemsDto.getProductId(),
            basketItemsDto.getQuantity(),
            basketItemsDto.getCost()
        );

        basketItems.setBasketItemsId(id);

        if(!basketItemsValidationService
            .basketItemsValidation(basketItemsDto, redirectAttributes)){
                basketItemsService.saveBasketItems(basketItems);
        }else{
            returnRedirect = "redirect:/basket-items/update-form/" + id;
        }

        return returnRedirect;
    }

    @GetMapping("/delete/{id}")
    public String delete(
        @PathVariable(value = "id") Long id
    ){
        basketItemsService.deleteBasketItemsById(id);
        return "redirect:/basket-items/list";
    }
}
