package com.simple.pos.simplepointofsale.controller;

import java.util.ArrayList;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.InventoryLocationsDto;
import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;
import com.simple.pos.simplepointofsale.model.InventoryLocations;
import com.simple.pos.simplepointofsale.service.AddressesService;
import com.simple.pos.simplepointofsale.service.InventoryLocationsService;
import com.simple.pos.simplepointofsale.service.ProductsService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.PaginationService;
import com.simple.pos.simplepointofsale.validationService.InventoryLocationsValidation;

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
@RequestMapping("/inventory-locations")
public class InventoryLocationsController {
    
    private static Logger logger = LoggerFactory.getLogger(InventoryLocationsController.class);

    private static String titleCRUD = "Inventory Locations";
    private static String listLink = "inventory-locations/list";
    private static String saveFormLink = "inventory-locations/add-form";
    private static String updateFormLink = "inventory-locations/update-form";
    private static String deleteFormLink = "inventory-locations/delete";
    private static String postSaveLink = "inventory-locations/save";
    private static String savePage = "Save";
    private static String updatePage = "Update";

    @Autowired
    private InventoryLocationsService inventoryLocationsService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    InventoryLocationsValidation inventoryLocationsValidation;

    @Autowired
    ProductsService productsService;

    @Autowired
    AddressesService addressesService;

    @Autowired
    PaginationService paginationService;

    @GetMapping("/list")
    public String viewInventoryLocationMethodPage(Model model, 
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
            inventoryLocationsService.getSize(),
            "inventoryLocationsId"
        );
        PaginationDto paginationDto = paginationService
            .paginationService(paginationRequestDto);

        Pageable pageable = paginationDto.getPageable();
        Integer pageList = paginationDto.getPageList();
        Integer nextPageList = paginationDto.getNextPageList();
        Integer totalPage = paginationDto.getTotalPage();

        List<InventoryLocations> lInventoryLocations = new ArrayList<>();
        lInventoryLocations = inventoryLocationsService.getAllInventoryLocationAscDesc(pageable);
        List<InventoryLocations> lInventoryLocationsFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(InventoryLocations inventoryLocations: lInventoryLocations){
                if(inventoryLocations.getInventoryLocationsId() == Long.parseLong(filtering)){
                    lInventoryLocationsFiltering.add(inventoryLocations);
                }
            }
            lInventoryLocations = lInventoryLocationsFiltering;
        }else{
            filtering = "";
        }

        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listInventoryLocations", lInventoryLocations);
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

        return "inventory_location_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        InventoryLocations inventoryLocations = new InventoryLocations();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("inventoryLocations", inventoryLocations);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);
        model.addAttribute("saveOrUpdate", savePage);

        model.addAttribute("listProduct", productsService.getAllProduct());
        model.addAttribute("listAddresses", addressesService.getAllAddresses());

        return "inventory_location_ui/add_inventory_location";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("inventoryLocations") InventoryLocationsDto inventoryLocationsDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/inventory-locations/list";

        logger.info("{}", inventoryLocationsDto.toString());
        
        if(!inventoryLocationsValidation
            .inventoryLocationValidation(inventoryLocationsDto, redirectAttributes)){
                inventoryLocationsService.saveInventoryLocations(new InventoryLocations(
                    inventoryLocationsDto.getProductId(),
                    inventoryLocationsDto.getLocationAddressId(),
                    inventoryLocationsDto.getQuantityInStock(),
                    inventoryLocationsDto.getReorderLevel(),
                    inventoryLocationsDto.getReorderQuantity(),
                    inventoryLocationsDto.getTotalAverageMonthlyUsage(),
                    inventoryLocationsDto.getOtherInventoryDetails()
                ));
        }else{
            returnRedirect = "redirect:/inventory-locations/add-form";
        }

        return returnRedirect;
    }

    @GetMapping("/update-form/{id}")
    public String updateInventoryLocation(
        @PathVariable(value = "id") Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        InventoryLocations inventoryLocations = inventoryLocationsService.getInventoryLocationsById(id);
        
        InventoryLocationsDto inventoryLocationsDto = new InventoryLocationsDto(
            inventoryLocations.getProductId(),
            inventoryLocations.getLocationAddressId(),
            inventoryLocations.getQuantityInStock(),
            inventoryLocations.getReorderLevel(),
            inventoryLocations.getReorderQuantity(),
            inventoryLocations.getTotalAverageMonthlyUsage(),
            inventoryLocations.getOtherInventoryDetails()
        );

        model.addAttribute("updateFormLink", updateFormLink + "/" + id);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("listLink", listLink);
        model.addAttribute("inventoryLocationsDto", inventoryLocationsDto);
        model.addAttribute("inventoryLocations", inventoryLocations);
        model.addAttribute("saveOrUpdate", updatePage);

        model.addAttribute("listProduct", productsService.getAllProduct());
        model.addAttribute("listAddresses", addressesService.getAllAddresses());
        model.addAttribute("product_id", inventoryLocations.getProductId());
        model.addAttribute("address_id", inventoryLocations.getLocationAddressId());

        return "inventory_location_ui/update_inventory_location";
    }

    @PostMapping("/update-form/{id}")
    public String updateInventoryLocations(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("inventoryLocations") InventoryLocationsDto inventoryLocationsDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/inventory-locations/list";

        InventoryLocations inventoryLocations = new InventoryLocations(
            inventoryLocationsDto.getProductId(),
            inventoryLocationsDto.getLocationAddressId(),
            inventoryLocationsDto.getQuantityInStock(),
            inventoryLocationsDto.getReorderLevel(),
            inventoryLocationsDto.getReorderQuantity(),
            inventoryLocationsDto.getTotalAverageMonthlyUsage(),
            inventoryLocationsDto.getOtherInventoryDetails()
        );

        inventoryLocations.setInventoryLocationsId(id);

        if(!inventoryLocationsValidation
            .inventoryLocationValidation(inventoryLocationsDto, redirectAttributes)){
                inventoryLocationsService.saveInventoryLocations(inventoryLocations);
        }else{
            returnRedirect = "redirect:/inventory-locations/update-form/" + id;
        }
    
        return returnRedirect;
    }

    @GetMapping("/delete/{id}")
    public String delete(
        @PathVariable(value = "id") Long id
    ){
        inventoryLocationsService.deleteInventoryLocationsById(id);
        return "redirect:/inventory-locations/list";
    }
}
