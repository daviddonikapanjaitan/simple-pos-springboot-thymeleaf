package com.simple.pos.simplepointofsale.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;
import com.simple.pos.simplepointofsale.Dto.ProductSuppliersDto;
import com.simple.pos.simplepointofsale.model.ProductSuppliers;
import com.simple.pos.simplepointofsale.model.Products;
import com.simple.pos.simplepointofsale.model.Suppliers;
import com.simple.pos.simplepointofsale.service.ProductSupplierService;
import com.simple.pos.simplepointofsale.service.ProductsService;
import com.simple.pos.simplepointofsale.service.SuppliersService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.utils.PaginationService;
import com.simple.pos.simplepointofsale.validationService.ProductSuppliersValidationService;

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

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    ProductSuppliersValidationService productSuppliersValidationService;

    @Autowired
    ProductsService productsService;

    @Autowired
    SuppliersService suppliersService;

    @Autowired
    PaginationService paginationService;

    @GetMapping("/list")
    public String viewProductSupplierMethodPage(Model model, 
        @RequestParam(defaultValue = "ascDesc") String ascDesc,
        @RequestParam(defaultValue = "page") String page,
        @RequestParam(defaultValue = "size") String size,
        @RequestParam(defaultValue = "filtering") String filtering){
        PaginationRequestDto paginationRequestDto = new PaginationRequestDto(
            ascDesc,
            page,
            size,
            filtering,
            productSupplierService.getSize(),
            "productSuppliersId"
        );
        PaginationDto paginationDto = paginationService
            .paginationService(paginationRequestDto);

        Pageable pageable = paginationDto.getPageable();
        Integer pageList = paginationDto.getPageList();
        Integer nextPageList = paginationDto.getNextPageList();
        Integer totalPage = paginationDto.getTotalPage();

        List<ProductSuppliers> lProductSuppliers = new ArrayList<>();
        lProductSuppliers = productSupplierService.getAllProductSuppliersAscDesc(pageable);
        List<ProductSuppliers> lProductSuppliersFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(ProductSuppliers productSuppliers : lProductSuppliers){
                if(productSuppliers.getProductSuppliersId() == Long.parseLong(filtering)){
                    lProductSuppliersFiltering.add(productSuppliers);
                }
            }
            lProductSuppliers = lProductSuppliersFiltering;
        }else{
            filtering = "";
        }

        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listProductSupplier", lProductSuppliers);
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

        return "product_supplier_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        ProductSuppliers productSuppliers = new ProductSuppliers();

        List<Products> lProducts = productsService.getAllProduct();
        List<Suppliers> lSuppliers = suppliersService.getAllSuppliers();

        model.addAttribute("listProduct", lProducts);
        model.addAttribute("listSuppliers", lSuppliers);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("productSuppliers", productSuppliers);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "product_supplier_ui/add_product_supplier";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("productSupplier") ProductSuppliersDto productSuppliersDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/product-supplier/list";
        logger.info("{}", productSuppliersDto.toString());

        Date firstItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        Date lastItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getLastItemSuppliedDate(), "yyyy-MM-dd");
        Date deliveryLeadTime = converterService.stringToDate(productSuppliersDto.getDeliveryLeadTime(), "yyyy-MM-dd");

        if(!productSuppliersValidationService
            .productSuppliersValidation(productSuppliersDto, redirectAttributes)){
                productSupplierService.saveProductSuppliers(
                    new ProductSuppliers(
                        Long.parseLong(productSuppliersDto.getProductId()),
                        productSuppliersDto.getSupplierCode(),
                        Long.parseLong(productSuppliersDto.getValueSuppliedToDate()),
                        Long.parseLong(productSuppliersDto.getTotalQuantitySuppliedToDate()),
                        firstItemSuppliedDate,
                        lastItemSuppliedDate,
                        deliveryLeadTime,
                        Long.parseLong(productSuppliersDto.getStandardPrice()),
                        Long.parseLong(productSuppliersDto.getPercentageDiscount()),
                        Long.parseLong(productSuppliersDto.getMinimumOrderQuantity()),
                        Long.parseLong(productSuppliersDto.getMaximumOrderQuantity()),
                        productSuppliersDto.getOtherItemSuppliersDetails()
                    )
                );
        }else{
            redirectLink = "redirect:/product-supplier/add-form";
        }

        return redirectLink;
    }

    @GetMapping("/update-form/{id}")
    public String updateFormProductSuppliers(
        @PathVariable Long id,
        Model model
    ){
        List<Products> lProducts = productsService.getAllProduct();
        List<Suppliers> lSuppliers = suppliersService.getAllSuppliers();

        addAttributeService.addFirstNameAttribute(model);
        ProductSuppliers productSuppliers = productSupplierService.getProductSuppliersById(id);
        
        String firstItemSuppliedDate = converterService.dateToString(productSuppliers.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        String lastItemSuppliedDate = converterService.dateToString(productSuppliers.getLastItemSuppliedDate(), "yyyy-MM-dd");
        String deliveryLeadTime = converterService.dateToString(productSuppliers.getDeliveryLeadTime(), "yyyy-MM-dd");

        ProductSuppliersDto productSuppliersDto = new ProductSuppliersDto(
            productSuppliers.getProductId().toString(),
            productSuppliers.getSupplierCode(),
            productSuppliers.getValueSuppliedToDate().toString(),
            productSuppliers.getTotalQuantitySuppliedToDate().toString(),
            firstItemSuppliedDate,
            lastItemSuppliedDate,
            deliveryLeadTime,
            productSuppliers.getStandardPrice().toString(),
            productSuppliers.getPercentageDiscount().toString(),
            productSuppliers.getMinimumOrderQuantity().toString(),
            productSuppliers.getMaximumOrderQuantity().toString(),
            productSuppliers.getOtherItemSuppliersDetails().toString()
        );

        model.addAttribute("product_id", productSuppliers.getProductId());
        model.addAttribute("supplier_code", productSuppliers.getSupplierCode());
        model.addAttribute("listProducts", lProducts);
        model.addAttribute("listSuppliers", lSuppliers);
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
        @ModelAttribute("productSupplier") ProductSuppliersDto productSuppliersDto,
        RedirectAttributes redirectAttributes
    ){
        logger.info("{}", productSuppliersDto.toString());

        String redirectLink = "redirect:/product-supplier/list";

        Date firstItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getFirstItemSuppliedDate(), "yyyy-MM-dd");
        Date lastItemSuppliedDate = converterService.stringToDate(productSuppliersDto.getLastItemSuppliedDate(), "yyyy-MM-dd");
        Date deliveryLeadTime = converterService.stringToDate(productSuppliersDto.getDeliveryLeadTime(), "yyyy-MM-dd");

        if(!productSuppliersValidationService
            .productSuppliersValidation(productSuppliersDto, redirectAttributes)){
                ProductSuppliers productSuppliers = new ProductSuppliers(
                    Long.parseLong(productSuppliersDto.getProductId()),
                    productSuppliersDto.getSupplierCode(),
                    Long.parseLong(productSuppliersDto.getValueSuppliedToDate()),
                    Long.parseLong(productSuppliersDto.getTotalQuantitySuppliedToDate()),
                    firstItemSuppliedDate,
                    lastItemSuppliedDate,
                    deliveryLeadTime,
                    Long.parseLong(productSuppliersDto.getStandardPrice()),
                    Long.parseLong(productSuppliersDto.getPercentageDiscount()),
                    Long.parseLong(productSuppliersDto.getMinimumOrderQuantity()),
                    Long.parseLong(productSuppliersDto.getMaximumOrderQuantity()),
                    productSuppliersDto.getOtherItemSuppliersDetails()
                );
        
                productSuppliers.setProductSuppliersId(id);
        
                productSupplierService.saveProductSuppliers(productSuppliers);
        }else{
            redirectLink = "redirect:/product-supplier/update-form/" + id;
        }
        
        return redirectLink;
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(
        @PathVariable(value = "id") Long id
    ){
        this.productSupplierService.deleteProductSuppliers(id);
        return "redirect:/product-supplier/list";
    }
}
