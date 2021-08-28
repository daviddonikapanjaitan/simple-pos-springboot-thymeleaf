package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Products;

public interface ProductsService {
    
    List<Products> getAllProduct();
    void saveProduct(Products products);
    Products getProductById(Long id);
    void deleteProduct(Long id);
}
