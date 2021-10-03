package com.simple.pos.simplepointofsale.controller;

import java.util.ArrayList;
import java.util.List;

import com.simple.pos.simplepointofsale.Dto.AddressTypesDto;
import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;
import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.service.AddressTypesService;
import com.simple.pos.simplepointofsale.utils.AddAttributeService;
import com.simple.pos.simplepointofsale.utils.PaginationService;
import com.simple.pos.simplepointofsale.validationService.AddressTypesValidationService;

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
@RequestMapping("/address-type")
public class AddressTypesController {
    
    private static Logger logger = LoggerFactory.getLogger(AddressTypes.class);

    private static String titleCRUD = "AddressTypes";
    private static String listLink = "address-type/list";
    private static String saveFormLink = "address-type/add-form";
    private static String updateFormLink = "address-type/update-form";
    private static String deleteFormLink = "address-type/delete";
    private static String postSaveLink = "address-type/save";

    @Autowired
    private AddressTypesService addressTypesService;

    @Autowired
    AddAttributeService addAttributeService;

    @Autowired
    AddressTypesValidationService addressTypesValidationService;

    @Autowired
    PaginationService paginationService;

    @GetMapping("/list")
    public String viewAddressTypeMethodPage(Model model, 
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
            addressTypesService.getSize(),
            "addressTypeCode"
        );
        PaginationDto paginationDto = paginationService
            .paginationService(paginationRequestDto);

        Pageable pageable = paginationDto.getPageable();
        Integer pageList = paginationDto.getPageList();
        Integer nextPageList = paginationDto.getNextPageList();
        Integer totalPage = paginationDto.getTotalPage();

        List<AddressTypes> lAddressTypes = new ArrayList<>();
        lAddressTypes = addressTypesService.getAllAddressesTypesAscDesc(pageable);
        List<AddressTypes> lAddressFiltering = new ArrayList<>();

        if(!filtering.equalsIgnoreCase("filtering")){
            for(AddressTypes addresses : lAddressTypes){
                if(addresses.getAddressTypeCode().contains(filtering)){
                    lAddressFiltering.add(addresses);
                }
            }
            lAddressTypes = lAddressFiltering;
        }else{
            filtering = "";
        }

        addAttributeService.addFirstNameAttribute(model);
        model.addAttribute("updateFormLink", updateFormLink);
        model.addAttribute("listAddressType", lAddressTypes);
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

        return "address_type_ui/index";
    }

    @GetMapping("/add-form")
    public String addForm(Model model){
        addAttributeService.addFirstNameAttribute(model);
        AddressTypes addressTypes = new AddressTypes();

        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressTypes", addressTypes);
        model.addAttribute("listLink", listLink);
        model.addAttribute("postSaveLink", postSaveLink);

        return "address_type_ui/add_address_type";
    }

    @PostMapping("/save")
    public String save(
        @ModelAttribute("addressTypes") AddressTypesDto addressTypesDto,
        RedirectAttributes redirectAttributes
    ){
        String redirectLink = "redirect:/address-type/list";
        logger.info("{}", addressTypesDto.toString());

        if(!addressTypesValidationService
            .addressTypesValidation(addressTypesDto, redirectAttributes)){
                addressTypesService.saveAddressTypes(new AddressTypes(
                    addressTypesDto.getAddressTypeCode(),
                    addressTypesDto.getAddressTypeDescription()
                ));
        }else{
            redirectLink = "redirect:/address-type/add-form";
        }

        return redirectLink;
    }

    @GetMapping("/update-form/{id}")
    public String updateFormAddressTypes(
        @PathVariable Long id,
        Model model
    ){
        addAttributeService.addFirstNameAttribute(model);
        AddressTypes addressTypes = addressTypesService.getAddressTypesById(id);

        AddressTypesDto addressTypesDto = new AddressTypesDto(
            addressTypes.getAddressTypeCode(),
            addressTypes.getAddressTypeDescription()
        );

        model.addAttribute("updateFormLink", updateFormLink + '/' + id);
        model.addAttribute("listLink", listLink);
        model.addAttribute("titleCRUD", titleCRUD);
        model.addAttribute("addressTypesDto", addressTypesDto);
        model.addAttribute("addressTypesId", id);

        return "address_type_ui/update_address_type";
    }

    @PostMapping("/update-form/{id}")
    public String updateAddressTypes(
        @PathVariable(value = "id") Long id,
        @ModelAttribute("addressTypes") AddressTypesDto addressTypesDto,
        RedirectAttributes redirectAttributes
    ){
        String returnRedirect = "redirect:/address-type/list";

        AddressTypes addressTypes = new AddressTypes(
            addressTypesDto.getAddressTypeCode(),
            addressTypesDto.getAddressTypeDescription()
        );

        addressTypes.setAddressTypeId(id);

        if(!addressTypesValidationService
            .addressTypesValidation(addressTypesDto, redirectAttributes)){
                
            addressTypesService.saveAddressTypes(addressTypes);
        }else{
            returnRedirect = "redirect:/address-type/update-form/" + id;
        }

        return returnRedirect;
    }

    @GetMapping("/delete/{id}")
    public String deleteAdderssTypes(
        @PathVariable(value = "id") Long id
    ){
        this.addressTypesService.deleteAddressTypesById(id);
        return "redirect:/address-type/list";
    }
}
