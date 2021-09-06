package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.ProductTypesDto;
import com.simple.pos.simplepointofsale.model.ProductTypes;
import com.simple.pos.simplepointofsale.service.ProductTypesService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.validationService.ProductTypesServiceValidation;

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
    AddAttributeService addAttributeService;

    @Autowired
    ProductTypesServiceValidation productTypesServiceValidation;

    @GetMapping("/list")
    public String viewProductTypesMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProductTypes", productTypesService.getAllProductTypes());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);

        return "product_types_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
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
        @ModelAttribute("productTypes") ProductTypesDto productTypesDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/product-types/list";
        logger.info("{}", productTypesDto.toString());

        if(!productTypesServiceValidation
            .productTypesValidation(productTypesDto, redirectAttributes)){
                productTypesService.saveProductTypes(
                    new ProductTypes(
                        productTypesDto.getProductTypeCode(),
                        productTypesDto.getProductTypeDescription()
                    )
                );
        }else{
            redirectLink = "redirect:/product-types/add-form";
        }

        return redirectLink;
    }

    @GetMapping("/update-form/{id}")
    public String updateProductTypesForm(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
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
