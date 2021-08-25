package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.ProductSuppliers;

public interface ProductSupplierService {
    
    List<ProductSuppliers> getAllProductSuppliers();
    void saveProductSuppliers(ProductSuppliers productSuppliers);
    ProductSuppliers getProductSuppliersById(Long id);
    void deleteProductSuppliers(Long id);
}
