package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.InventoryLocations;

import org.springframework.data.domain.Pageable;

public interface InventoryLocationsService {

    List<InventoryLocations> getAllInventoryLocations();
    void saveInventoryLocations(InventoryLocations inventoryLocations);
    InventoryLocations getInventoryLocationsById(Long id);
    void deleteInventoryLocationsById(Long id);
    List<InventoryLocations> getAllInventoryLocationAscDesc(Pageable pageable);
    int getSize();
}
