package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.ProductTypes;
import com.simple.pos.simplepointofsale.repository.ProductTypesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductTypesServiceImpl implements ProductTypesService {

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

    @Autowired
    ProductTypesRepository productTypesRepository;

    @Override
    public List<ProductTypes> getAllProductTypes() {
        return productTypesRepository.findAll();
    }

    @Override
    public void saveProductTypes(ProductTypes productTypes) {
        this.productTypesRepository.save(productTypes);
    }

    @Override
    public ProductTypes getProductTypesById(Long id) {
        Optional<ProductTypes> optional = productTypesRepository.findById(id);
        ProductTypes productTypes = null;

        if(optional.isPresent()){
            productTypes = optional.get();
        }else{
            throw new RuntimeException("Payment Method not found for id :: " + id);
        }
        return productTypes;
    }

    @Override
    public void deleteProductTypes(Long id) {
        this.productTypesRepository.deleteById(id);
    }

    @Override
    public List<ProductTypes> getAllProductTypesAscDesc(Pageable pageable) {
        List<ProductTypes> lProductTypes = new ArrayList<>();
        logger.info("{}", lProductTypes.toString());

        lProductTypes = productTypesRepository.findAll(pageable).getContent();

        return lProductTypes;
    }

    @Override
    public int getSize() {
        return productTypesRepository.findAll().size();
    }
}
