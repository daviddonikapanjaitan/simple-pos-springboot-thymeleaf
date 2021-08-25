package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Products;

public interface ProductsService {
    
    List<Products> getAllProductTypes();
    void saveProductTypes(Products products);
    Products getProductTypesById(Long id);
    void deleteProductTypes(Long id);
}
