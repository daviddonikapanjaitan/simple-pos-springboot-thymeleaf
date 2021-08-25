package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.InventoryLocations;
import com.simple.pos.simplepointofsale.repository.InventoryLocationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryLocationsServiceImpl implements InventoryLocationsService{

    @Autowired
    private InventoryLocationsRepository inventoryLocationsRepository;

    @Override
    public List<InventoryLocations> getAllInventoryLocations() {
        return inventoryLocationsRepository.findAll();
    }

    @Override
    public void saveInventoryLocations(InventoryLocations inventoryLocations) {
        this.inventoryLocationsRepository.save(inventoryLocations);
    }

    @Override
    public InventoryLocations getInventoryLocationsById(Long id) {
        Optional<InventoryLocations> optional = inventoryLocationsRepository.findById(id);
        InventoryLocations inventoryLocations = null;
        if(optional.isPresent()){
            inventoryLocations = optional.get();
        }else{
            throw new RuntimeException("Inventory Locations not found for id :: " + id);
        }

        return inventoryLocations;
    }

    @Override
    public void deleteInventoryLocationsById(Long id) {
        this.inventoryLocationsRepository.deleteById(id);
    }
}
