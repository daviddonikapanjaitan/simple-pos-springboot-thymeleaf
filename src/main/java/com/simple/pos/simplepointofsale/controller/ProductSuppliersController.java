package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.ProductSuppliersDto;
import com.simple.pos.simplepointofsale.model.ProductSuppliers;
import com.simple.pos.simplepointofsale.service.ProductSupplierService;
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
@RequestMapping("/product-supplier")
public class ProductSuppliersController {
     
    private static Logger logger = LoggerFactory.getLogger(ProductSuppliers.class);

    private static String titleCRUD = "Product Supplier";
    private static String listLink = "product-supplier/list";
    private static String saveFormLink = "product-supplier/add-form";
    private static String updateFormLink = "product-supplier/update-form";
    private static String deleteFormLink = "product-supplier/delete";
    private static String postSaveLink = "product-supplier/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private ProductSupplierService productSupplierService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/list")
    public String viewProductSupplierMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProductSupplier", productSupplierService.getAllProductSuppliers());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);

        return "product_supplier_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        ProductSuppliers productSuppliers = new ProductSuppliers();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("productSuppliers", productSuppliers);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "product_supplier_ui/add_product_supplier";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("productSupplier") ProductSuppliersDto productSuppliersDto
    ){
        logger.info("{}", productSuppliersDto.toString());

        Date firstItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        Date lastItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getLastItemSuppliedDate(), "yyyy-MM-dd");
        Date deliveryLeadTime = converterService.stringToDate(productSuppliersDto.getDeliveryLeadTime(), "yyyy-MM-dd");

        productSupplierService.saveProductSuppliers(
            new ProductSuppliers(
                productSuppliersDto.getProductId(),
                productSuppliersDto.getSupplierCode(),
                productSuppliersDto.getValueSuppliedToDate(),
                productSuppliersDto.getTotalQuantitySuppliedToDate(),
                firstItemSuppliedDate,
                lastItemSuppliedDate,
                deliveryLeadTime,
                productSuppliersDto.getStandardPrice(),
                productSuppliersDto.getPercentageDiscount(),
                productSuppliersDto.getMinimumOrderQuantity(),
                productSuppliersDto.getMaximumOrderQuantity(),
                productSuppliersDto.getOtherItemSuppliersDetails()
            )
        );

        return "redirect:/product-supplier/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateFormProductSuppliers(
        @PathVariable Long id,
        Model model
    ){
        ProductSuppliers productSuppliers = productSupplierService.getProductSuppliersById(id);
        
        String firstItemSuppliedDate = converterService.dateToString(productSuppliers.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        String lastItemSuppliedDate = converterService.dateToString(productSuppliers.getLastItemSuppliedDate(), "yyyy-MM-dd");
        String deliveryLeadTime = converterService.dateToString(productSuppliers.getDeliveryLeadTime(), "yyyy-MM-dd");

        ProductSuppliersDto productSuppliersDto = new ProductSuppliersDto(
            productSuppliers.getProductId(),
            productSuppliers.getSupplierCode(),
            productSuppliers.getValueSuppliedToDate(),
            productSuppliers.getTotalQuantitySuppliedToDate(),
            firstItemSuppliedDate,
            lastItemSuppliedDate,
            deliveryLeadTime,
            productSuppliers.getStandardPrice(),
            productSuppliers.getPercentageDiscount(),
            productSuppliers.getMinimumOrderQuantity(),
            productSuppliers.getMaximumOrderQuantity(),
            productSuppliers.getOtherItemSuppliersDetails()
        );

        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("productSuppliersDto", productSuppliersDto);
        model.addAttribute("productSuppliersId", id);
        model.addAttribute("saveOrUpdate", updatePage);
        
        return "product_supplier_ui/update_product_supplier";
    }

    @PostMapping("/update-form/{id}")
    public String updateProductSupplier(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("productSupplier") ProductSuppliersDto productSuppliersDto
    ){

        Date firstItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        Date lastItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getLastItemSuppliedDate(), "yyyy-MM-dd");
        Date deliveryLeadTime = converterService.stringToDate(productSuppliersDto.getDeliveryLeadTime(), "yyyy-MM-dd");

        ProductSuppliers productSuppliers = new ProductSuppliers(
            productSuppliersDto.getProductId(),
                productSuppliersDto.getSupplierCode(),
                productSuppliersDto.getValueSuppliedToDate(),
                productSuppliersDto.getTotalQuantitySuppliedToDate(),
                firstItemSuppliedDate,
                lastItemSuppliedDate,
                deliveryLeadTime,
                productSuppliersDto.getStandardPrice(),
                productSuppliersDto.getPercentageDiscount(),
                productSuppliersDto.getMinimumOrderQuantity(),
                productSuppliersDto.getMaximumOrderQuantity(),
                productSuppliersDto.getOtherItemSuppliersDetails()
        );

        productSuppliers.setProductSuppliersId(id);

        productSupplierService.saveProductSuppliers(productSuppliers);
        
        return "redirect:/product-supplier/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(
        @PathVariable(value = "id") Long id
    ){
        this.productSupplierService.deleteProductSuppliers(id);
        return "redirect:/product-supplier/list";
    }
}