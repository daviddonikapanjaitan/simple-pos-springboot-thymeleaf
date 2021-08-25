package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.InventoryLocations;

public interface InventoryLocationsService {

    List<InventoryLocations> getAllInventoryLocations();
    void saveInventoryLocations(InventoryLocations inventoryLocations);
    InventoryLocations getInventoryLocationsById(Long id);
    void deleteInventoryLocationsById(Long id);
}
