package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.SupplierLocationDto;
import com.simple.pos.simplepointofsale.model.SupplierLocation;
import com.simple.pos.simplepointofsale.service.AddressesService;
import com.simple.pos.simplepointofsale.service.SupplierLocationService;
import com.simple.pos.simplepointofsale.service.SuppliersService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.ConverterService;
import com.simple.pos.simplepointofsale.validationService.SupplierLocationValidationService;

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
@RequestMapping("/supplier-location")
public class SupplierLocationsController {
    
    private static Logger logger = LoggerFactory.getLogger(SupplierLocationsController.class);

    private static String titleCRUD = "Supplier Location";
    private static String listLink = "supplier-location/list";
    private static String saveFormLink = "supplier-location/add-form";
    private static String updateFormLink = "supplier-location/update-form";
    private static String deleteFormLink = "supplier-location/delete";
    private static String postSaveLink = "supplier-location/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private SupplierLocationService supplierLocationService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    SupplierLocationValidationService supplierLocationValidationService;

    @Autowired
    SuppliersService suppliersService;

    @Autowired
    AddressesService addressesService;

    @GetMapping("/list")
    public String viewSupplierLocationsMethodPage(Model model){
        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listSupplierLocations", supplierLocationService.getAllSupplierLocations());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
    
        return "supplier_location_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        SupplierLocation supplierLocation = new SupplierLocation();

        model.addAttribute("listSuppliers", suppliersService.getAllSuppliers());
        model.addAttribute("listAddresses", addressesService.getAllAddresses());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("supplierLocation", supplierLocation);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "supplier_location_ui/add_supplier_location";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("supplierLocation") SupplierLocationDto supplierLocationDto,
        RedirectAttributes redirectAttributes        
    ){
        String returnRedirect = "redirect:/supplier-location/list";
        logger.info("{}", supplierLocationDto.toString());
    
        Date dateFrom = converterService.stringToDate(supplierLocationDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(supplierLocationDto.getDateTo(), "yyyy-MM-dd");

        if(!supplierLocationValidationService.supplierLocationValidation(
            supplierLocationDto, 
            redirectAttributes)
        ){
            supplierLocationService.saveSupplierLocations(
                new SupplierLocation(
                    supplierLocationDto.getSupplierCode(),
                    Long.parseLong(supplierLocationDto.getAddressId()),
                    dateFrom,
                    dateTo
                )
            );
        }else{
            returnRedirect = "redirect:/supplier-location/add-form";
        }

        return returnRedirect;
    }

    @GetMapping("/update-form/{id}")
    public String updateSupplierLocation(
        @PathVariable(value = "id") Long id,
        Model model    
    ){
        addAttributeService.addFirstNameAttribute(model);
        SupplierLocation supplierLocation = supplierLocationService.getSupplierLocationsById(id);

        String dateFrom = converterService.dateToString(supplierLocation.getDateFrom(), "yyyy-MM-dd");
        String dateTo = converterService.dateToString(supplierLocation.getDateTo(), "yyyy-MM-dd");
    
        SupplierLocationDto supplierLocationDto = new SupplierLocationDto(
            supplierLocation.getSupplierCode(),
            supplierLocation.getAddressId().toString(),
            dateFrom,
            dateTo
        );

        model.addAttribute("address_id", supplierLocation.getAddressId());
        model.addAttribute("supplier_code", supplierLocation.getSupplierCode());
        model.addAttribute("listSuppliers", suppliersService.getAllSuppliers());
        model.addAttribute("listAddresses", addressesService.getAllAddresses());
        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("supplierLocationDto", supplierLocationDto);
        model.addAttribute("supplierLocationId", id);
        model.addAttribute("saveOrUpdate", updatePage);

        return "supplier_location_ui/update_supplier_location";
    }

    @PostMapping("/update-form/{id}")
    public String updateSupplierLocation(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("supplierLocation")  SupplierLocationDto supplierLocationDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/supplier-location/list";

        Date dateFrom = converterService.stringToDate(supplierLocationDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(supplierLocationDto.getDateTo(), "yyyy-MM-dd");

        SupplierLocation supplierLocation = new SupplierLocation(
            supplierLocationDto.getSupplierCode(),
            Long.parseLong(supplierLocationDto.getAddressId()),
            dateFrom,
            dateTo
        );

        supplierLocation.setSupplierLocationId(id);

        if(
            !supplierLocationValidationService.supplierLocationValidation(
                supplierLocationDto, redirectAttributes
            )
        ){
            supplierLocationService.saveSupplierLocations(supplierLocation);
        }else{
            returnRedirect = "redirect:/supplier-location/update-form/" + id;
        }

        return returnRedirect;
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplierLocation(
        @PathVariable(value = "id") Long id
    ){
        this.supplierLocationService.deleteSupplierLocationsById(id);
        return "redirect:/supplier-location/list";
    }
}
