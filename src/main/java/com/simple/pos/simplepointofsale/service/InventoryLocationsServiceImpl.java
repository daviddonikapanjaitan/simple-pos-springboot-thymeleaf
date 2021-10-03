package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.InventoryLocations;
import com.simple.pos.simplepointofsale.repository.InventoryLocationsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryLocationsServiceImpl implements InventoryLocationsService{

    private static Logger logger = LoggerFactory.getLogger(InventoryLocationsServiceImpl.class);

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

    @Override
    public List<InventoryLocations> getAllInventoryLocationAscDesc(Pageable pageable) {
        List<InventoryLocations> lInventoryLocations = new ArrayList<>();
        logger.info("{}", lInventoryLocations.toString());

        lInventoryLocations = inventoryLocationsRepository.findAll(pageable).getContent();

        return lInventoryLocations;
    }

    @Override
    public int getSize() {
        return inventoryLocationsRepository.findAll().size();
    }
}
