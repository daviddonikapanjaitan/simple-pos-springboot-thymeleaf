package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.ProductTypesDto;
import com.simple.pos.simplepointofsale.model.ProductTypes;
import com.simple.pos.simplepointofsale.service.ProductTypesService;
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
@RequestMapping("/product-types")
public class ProductTypesController {
    
    private static Logger logger = LoggerFactory.getLogger(ProductTypesController.class);
    
    private static String titleCRUD = "Product Types";
    private static String listLink = "product-types/list";
    private static String saveFormLink = "product-types/add-form";
    private static String updateFormLink = "product-types/update-form";
    private static String deleteFormLink = "product-types/delete";
    private static String postSaveLink = "product-types/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";


    @Autowired
    private ProductTypesService productTypesService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/list")
    public String viewProductTypesMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProductTypes", productTypesService.getAllProductTypes());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);

        return "product_types_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        ProductTypes productTypes = new ProductTypes();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "product_types_ui/add_product_types";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("productTypes") ProductTypesDto productTypesDto
    ){
        logger.info("{}", productTypesDto.toString());

        productTypesService.saveProductTypes(
            new ProductTypes(
                productTypesDto.getProductTypeCode(),
                productTypesDto.getProductTypeDescription()
            )
        );

        return "redirect:/product-types/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateProductTypesForm(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        ProductTypes productTypes = productTypesService.getProductTypesById(id);

        ProductTypesDto productTypesDto = new ProductTypesDto(
            productTypes.getProductTypeCode(),
            productTypes.getProductTypeDescription()
        );

        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("productTypesDto", productTypesDto);
        model.addAttribute("productTypesId", id);
        model.addAttribute("saveOrUpdate", updatePage);

        return "product_types_ui/update_product_types";
    }

    @PostMapping("/update-form/{id}")
    public String updateProductTypes(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("productTypes") ProductTypesDto productTypesDto
    ){

        ProductTypes productTypes = new ProductTypes(
            productTypesDto.getProductTypeCode(),
            productTypesDto.getProductTypeDescription()
        );

        productTypes.setProductTypeId(id);

        productTypesService.saveProductTypes(productTypes);

        return "redirect:/product-types/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductType(
        @PathVariable(value = "id") Long id
    ){
        this.productTypesService.deleteProductTypes(id);
        return "redirect:/product-types/list";
    }
}
