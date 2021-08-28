package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Products;
import com.simple.pos.simplepointofsale.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProduct() {
        return productsRepository.findAll();
    }

    @Override
    public void saveProduct(Products products) {
        this.productsRepository.save(products);
    }

    @Override
    public Products getProductById(Long id) {
        Optional<Products> optional = productsRepository.findById(id);
        Products products = null;

        if(optional.isPresent()){
            products = optional.get();
        }else{
            throw new RuntimeException("Products not found for id :: " + id);
        }
        return products;
    }

    @Override
    public void deleteProduct(Long id) {
        this.productsRepository.deleteById(id);
    }
}
