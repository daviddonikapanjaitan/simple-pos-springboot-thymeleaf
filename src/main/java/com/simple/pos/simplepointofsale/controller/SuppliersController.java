package com.simple.pos.simplepointofsale.controller;

import com.simple.pos.simplepointofsale.Dto.SuppliersDto;
import com.simple.pos.simplepointofsale.model.Suppliers;
import com.simple.pos.simplepointofsale.service.SuppliersService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.validationService.SupplierValidationService;

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
@RequestMapping("/supplier")
public class SuppliersController {
    
    private static Logger logger = LoggerFactory.getLogger(SuppliersController.class);

    private static String titleCRUD = "Supplier";
    private static String listLink = "supplier/list";
    private static String saveFormLink = "supplier/add-form";
    private static String updateFormLink = "supplier/update-form";
    private static String deleteFormLink = "supplier/delete";
    private static String postSaveLink = "supplier/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private SuppliersService suppliersService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    SupplierValidationService supplierValidationService;

    @GetMapping("/list")
    public String viewSupplierMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listSupplier", suppliersService.getAllSuppliers());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
        return "supplier_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        Suppliers suppliers = new Suppliers();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("supplier", suppliers);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "supplier_ui/add_supplier";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("supplier") SuppliersDto suppliersDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/supplier/list";
        logger.info("{}", suppliersDto.toString());

        if(!supplierValidationService
            .supplierValidation(suppliersDto, redirectAttributes)){
                suppliersService.saveSuppliers(new Suppliers(
                    suppliersDto.getSupplierCode(),
                    suppliersDto.getSupplierName(),
                    suppliersDto.getSupplierAddress(),
                    suppliersDto.getSupplierEmail(),
                    suppliersDto.getSupplierPhone(),
                    suppliersDto.getOtherSupplierDetails()
                ));
        }else{
            redirectLink = "redirect:/supplier/add-form";
        }

        return redirectLink;
    }

    @GetMapping("/update-form/{id}")
    public String updateFormSupplier(
        @PathVariable Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        Suppliers suppliers = suppliersService.getSuppliersById(id);

        SuppliersDto suppliersDto = new SuppliersDto(
            suppliers.getSupplierCode(),
            suppliers.getSupplierName(),
            suppliers.getSupplierAddress(),
            suppliers.getSupplierEmail(),
            suppliers.getSupplierPhone(),
            suppliers.getOtherSupplierDetails()
        );

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("listLink", listLink);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("suppliersDto", suppliersDto);
        model.addAttribute("suppliersId", id);
        model.addAttribute("saveOrUpdate", updatePage);

        return "supplier_ui/update_supplier";
    }

    @PostMapping("/update-form/{id}")
    public String updateSupplier(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("supplier") SuppliersDto suppliersDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/supplier/list";

        if(!supplierValidationService
            .supplierValidation(suppliersDto, redirectAttributes)){
                Suppliers suppliers = new Suppliers(
                    suppliersDto.getSupplierCode(),
                    suppliersDto.getSupplierName(),
                    suppliersDto.getSupplierAddress(),
                    suppliersDto.getSupplierEmail(),
                    suppliersDto.getSupplierPhone(),
                    suppliersDto.getOtherSupplierDetails()
                );

                suppliers.setSuppliersId(id);
                suppliersService.saveSuppliers(suppliers);
        }else{
            redirectLink = "redirect:/supplier/update-form/" + id;
        }

        return redirectLink;
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(
        @PathVariable(value = "id") Long id
    ){
        this.suppliersService.deleteSuppliersById(id);
        return "redirect:/supplier/list";
    }
}