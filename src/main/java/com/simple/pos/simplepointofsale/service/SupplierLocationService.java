package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.SupplierLocation;

public interface SupplierLocationService {

    List<SupplierLocation> getAllSupplierLocations();
    void saveSupplierLocations(SupplierLocation supplierLocation);
    SupplierLocation getSupplierLocationsById(Long id);
    void deleteSupplierLocationsById(Long id);
}
