package com.simple.pos.simplepointofsale.controller;

import java.util.ArrayList;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.ProductTypesDto;
import com.simple.pos.simplepointofsale.model.ProductTypes;
import com.simple.pos.simplepointofsale.service.ProductTypesService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.validationService.ProductTypesServiceValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String viewProductTypesMethodPage(
        Model model,
        @RequestParam(defaultValue =  "ascDesc") String ascDesc,
        @RequestParam(defaultValue = "page") String page,
        @RequestParam(defaultValue = "size") String size,
        @RequestParam(defaultValue = "filtering") String filtering
    ) throws Exception{
        List<ProductTypes> lProductTypes = new ArrayList<>();
        Pageable pageable = null;
        Integer pageList = 0;
        Integer sizeList = 0;
        Integer nextPageList = 0;

        logger.info("size = {}", size);
        logger.info("page = {}", page);
        logger.info("ascDesc = {}", ascDesc);
        logger.info("filtering = {}", filtering);
        if(size.equalsIgnoreCase("size")){
            sizeList = 5;
            size = "";
        }else{
            sizeList = Integer.parseInt(size);
        }

        if(page.equalsIgnoreCase("page")){
            pageList = 0;
            page = "";
        }else{
            pageList = Integer.parseInt(page) - 1;
        }

        if(ascDesc.equalsIgnoreCase("asc")){
            pageable = PageRequest.of(pageList, sizeList, Sort.by("productTypeCode").ascending());
        }else if(ascDesc.equalsIgnoreCase("desc")){
            pageable = PageRequest.of(pageList, sizeList, Sort.by("productTypeCode").descending());
        }else{
            ascDesc = "";
            pageable = PageRequest.of(pageList, sizeList);
        }

        lProductTypes = productTypesService.getAllProductTypesAscDesc(pageable);
        List<ProductTypes> lProductTypesFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(ProductTypes productTypes: lProductTypes){
                if(productTypes.getProductTypeCode().contains(filtering)){
                    lProductTypesFiltering.add(productTypes);
                }
            }
            lProductTypes = lProductTypesFiltering;
        }else{
            filtering = "";
        }

        int totalPage = 0;
        int totalSize = productTypesService.getSize();
        logger.info("Total Size: {}", totalSize);
        if(totalSize % sizeList == 0){
            totalPage = (totalSize / sizeList);
        }else{
            totalPage = (totalSize / sizeList) + 1;
        }

        nextPageList = pageList + 2;

        logger.info("Product Size: " + lProductTypes.size());
        logger.info("Page: " + page);
        logger.info("Page List: " + pageList);
        logger.info("Page Size: " + totalPage);
        logger.info("Next Page List: " + nextPageList);

        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProductTypes", lProductTypes);
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
        @ModelAttribute("productTypes") ProductTypesDto productTypesDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/product-types/list";

        if(!productTypesServiceValidation
            .productTypesValidation(productTypesDto, redirectAttributes)){
                ProductTypes productTypes = new ProductTypes(
                productTypesDto.getProductTypeCode(),
                productTypesDto.getProductTypeDescription()
            );

            productTypes.setProductTypeId(id);

            productTypesService.saveProductTypes(productTypes);
        }else{
            redirectLink = "redirect:/product-types/update-form/" + id;
        }

        return redirectLink;
    }

    @GetMapping("/delete/{id}")
    public String deleteProductType(
        @PathVariable(value = "id") Long id
    ){
        this.productTypesService.deleteProductTypes(id);
        return "redirect:/product-types/list";
    }
}
