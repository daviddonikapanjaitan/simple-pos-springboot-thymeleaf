package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.ProductsDto;
import com.simple.pos.simplepointofsale.model.Products;
import com.simple.pos.simplepointofsale.service.ProductsService;

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
@RequestMapping("/product")
public class ProductController {
    
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private static String titleCRUD = "Product";
    private static String listLink = "product/list";
    private static String saveFormLink = "product/add-form";
    private static String updateFormLink = "product/update-form";
    private static String deleteFormLink = "product/delete";
    private static String postSaveLink = "product/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private ProductsService productsService;

    @GetMapping("/list")
    public String viewProductMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProduct", productsService.getAllProduct());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);

        return "product_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        Products products = new Products();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("products", products);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "product_ui/add_products";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("product") ProductsDto productsDto
    ){
        logger.info("{}", productsDto.toString());
    
        productsService.saveProduct(new Products(
            productsDto.getProductTypeCode(),
            productsDto.getProductDetails(),
            productsDto.getProductName(),
            productsDto.getProductPrice(),
            productsDto.getProductDescription()
        ));

        return "redirect:/product/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateProductForm(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        Products products = productsService.getProductById(id);

        ProductsDto productsDto = new ProductsDto(
            products.getProductTypeCode(),
            products.getProductDetails(),
            products.getProductName(),
            products.getProductPrice(),
            products.getProductDescription()
        );

        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("productsDto", productsDto);
        model.addAttribute("productsId", products);
        model.addAttribute("saveOrUpdate", updatePage);
    
        return "product_ui/update_products";
    }

    @PostMapping("/update-form/{id}")
    public String updateProductForm(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("product") ProductsDto productsDto
    ){
        Products products = new Products(
            productsDto.getProductTypeCode(),
            productsDto.getProductDetails(),
            productsDto.getProductName(),
            productsDto.getProductPrice(),
            productsDto.getProductDescription()
        );

        products.setProductId(id);

        productsService.saveProduct(products);

        return "redirect:/product/list";
    }

}
