package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.ProductSuppliers;
import com.simple.pos.simplepointofsale.repository.ProductSuppliersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService{

    private static Logger logger = LoggerFactory.getLogger(AddressTypesServiceImpl.class);

    @Autowired
    ProductSuppliersRepository productSuppliersRepository;

    @Override
    public List<ProductSuppliers> getAllProductSuppliers() {
        return productSuppliersRepository.findAll();
    }

    @Override
    public void saveProductSuppliers(ProductSuppliers productSuppliers) {
        this.productSuppliersRepository.save(productSuppliers);
    }

    @Override
    public ProductSuppliers getProductSuppliersById(Long id) {
        Optional<ProductSuppliers> optional = productSuppliersRepository.findById(id);
        ProductSuppliers productSuppliers = null;

        if(optional.isPresent()){
            productSuppliers = optional.get();
        }else{
            throw new RuntimeException("Product Suppliers not found for id :: " + id);
        }

        return productSuppliers;
    }

    @Override
    public void deleteProductSuppliers(Long id) {
        this.productSuppliersRepository.deleteById(id);
    }

    @Override
    public List<ProductSuppliers> getAllProductSuppliersAscDesc(Pageable pageable) {
        List<ProductSuppliers> lProductSuppliers = new ArrayList<>();
        logger.info("{}", lProductSuppliers.toString());

        lProductSuppliers = productSuppliersRepository.findAll(pageable).getContent();

        return lProductSuppliers;
    }

    @Override
    public int getSize() {
        return productSuppliersRepository.findAll().size();
    }
}
