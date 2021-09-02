package com.simple.pos.simplepointofsale.controller;

import java.util.Date;

import com.simple.pos.simplepointofsale.Dto.SupplierLocationDto;
import com.simple.pos.simplepointofsale.model.SupplierLocation;
import com.simple.pos.simplepointofsale.service.SupplierLocationService;
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

    @GetMapping("/list")
    public String viewSupplierLocationsMethodPage(Model model){
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listSupplierLocations", supplierLocationService.getAllSupplierLocations());
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("saveFormLink", saveFormLink);
        model.addAttribute("deleteFormLink", deleteFormLink);
    
        return "supplier_location_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        SupplierLocation supplierLocation = new SupplierLocation();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("supplierLocation", supplierLocation);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        return "supplier_location_ui/add_supplier_location";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("supplierLocation") SupplierLocationDto supplierLocationDto        
    ){
        logger.info("{}", supplierLocationDto.toString());
    
        Date dateFrom = converterService.stringToDate(supplierLocationDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(supplierLocationDto.getDateTo(), "yyyy-MM-dd");

        supplierLocationService.saveSupplierLocations(
            new SupplierLocation(
                supplierLocationDto.getSupplierCode(),
                supplierLocationDto.getAddressId(),
                dateFrom,
                dateTo
            )
        );

        return "redirect:/supplier-location/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateSupplierLocation(
        @PathVariable(value = "id") Long id,
        Model model    
    ){
        SupplierLocation supplierLocation = supplierLocationService.getSupplierLocationsById(id);

        String dateFrom = converterService.dateToString(supplierLocation.getDateFrom(), "yyyy-MM-dd");
        String dateTo = converterService.dateToString(supplierLocation.getDateTo(), "yyyy-MM-dd");
    
        SupplierLocationDto supplierLocationDto = new SupplierLocationDto(
            supplierLocation.getSupplierCode(),
            supplierLocation.getAddressId(),
            dateFrom,
            dateTo
        );

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
        @ModelAttribute("supplierLocation")  SupplierLocationDto supplierLocationDto
    ){

        Date dateFrom = converterService.stringToDate(supplierLocationDto.getDateFrom(), "yyyy-MM-dd");
        Date dateTo = converterService.stringToDate(supplierLocationDto.getDateTo(), "yyyy-MM-dd");

        SupplierLocation supplierLocation = new SupplierLocation(
            supplierLocationDto.getSupplierCode(),
            supplierLocationDto.getAddressId(),
            dateFrom,
            dateTo
        );

        supplierLocation.setSupplierLocationId(id);

        supplierLocationService.saveSupplierLocations(supplierLocation);

        return "redirect:/supplier-location/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplierLocation(
        @PathVariable(value = "id") Long id
    ){
        this.supplierLocationService.deleteSupplierLocationsById(id);
        return "redirect:/supplier-location/list";
    }
}
