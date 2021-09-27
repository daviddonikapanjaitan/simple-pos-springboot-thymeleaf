package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Products;
import org.springframework.data.domain.Pageable;

public interface ProductsService {
    
    List<Products> getAllProduct();
    void saveProduct(Products products);
    Products getProductById(Long id);
    void deleteProduct(Long id);
    List<Products> getAllProductsAscDesc(Pageable pageable);
    int getSize();
}
