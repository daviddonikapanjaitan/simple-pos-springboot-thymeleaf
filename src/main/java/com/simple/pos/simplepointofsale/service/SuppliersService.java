package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Suppliers;

import org.springframework.data.domain.Pageable;

public interface SuppliersService {
    
    List<Suppliers> getAllSuppliers();
    void saveSuppliers(Suppliers suppliers);
    Suppliers getSuppliersById(Long id);
    void deleteSuppliersById(Long id);
    List<Suppliers> getAllSuppliersAscDesc(Pageable pageable);
    int getSize();
}
