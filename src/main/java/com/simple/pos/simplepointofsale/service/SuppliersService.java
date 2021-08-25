package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Suppliers;

public interface SuppliersService {
    
    List<Suppliers> getAllSuppliers();
    void saveSuppliers(Suppliers suppliers);
    Suppliers getSuppliersById(Long id);
    void deleteSuppliersById(Long id);
}
