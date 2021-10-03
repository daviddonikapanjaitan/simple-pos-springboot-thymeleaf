package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.SupplierLocation;
import com.simple.pos.simplepointofsale.repository.SupplierLocationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierLocationServiceImpl implements SupplierLocationService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

    @Autowired
    private SupplierLocationRepository supplierLocationRepository;

    @Override
    public List<SupplierLocation> getAllSupplierLocations() {
        return supplierLocationRepository.findAll();
    }

    @Override
    public void saveSupplierLocations(SupplierLocation supplierLocation) {
        this.supplierLocationRepository.save(supplierLocation);
    }

    @Override
    public SupplierLocation getSupplierLocationsById(Long id) {
        Optional<SupplierLocation> optional = supplierLocationRepository.findById(id);
        SupplierLocation supplierLocation = null;
        if(optional.isPresent()){
            supplierLocation = optional.get();
        }else{
            throw new RuntimeException("Supplier Location not found for id :: " + id);
        }
        return supplierLocation;
    }

    @Override
    public void deleteSupplierLocationsById(Long id) {
        this.supplierLocationRepository.deleteById(id);
    }

    @Override
    public List<SupplierLocation> getAllSupplierLocationAscDesc(Pageable pageable) {
        List<SupplierLocation> lSupplierLocations = new ArrayList<>();
        logger.info("{}", lSupplierLocations.toString());

        lSupplierLocations = supplierLocationRepository.findAll(pageable).getContent();

        return lSupplierLocations;
    }

    @Override
    public int getSize() {
        return supplierLocationRepository.findAll().size();
    }
}