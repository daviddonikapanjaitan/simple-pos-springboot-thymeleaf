package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Products;
import com.simple.pos.simplepointofsale.repository.ProductsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
 
@Service
public class ProductsServiceImpl implements ProductsService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

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

    @Override
    public List<Products> getAllProductsAscDesc(Pageable pageable) {
        List<Products> lProducts = new ArrayList<>();
        logger.info("{}", lProducts.toString());

        lProducts = productsRepository.findAll(pageable).getContent();

        return lProducts;
    }

    @Override
    public int getSize() {
        return productsRepository.findAll().size();
    }
}
