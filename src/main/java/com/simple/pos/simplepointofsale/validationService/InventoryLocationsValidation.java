package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.InventoryLocationsDto;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface InventoryLocationsValidation{

    boolean inventoryLocationValidation(
        InventoryLocationsDto inventoryLocationsDto,
        RedirectAttributes redirectAttributes
    );
}