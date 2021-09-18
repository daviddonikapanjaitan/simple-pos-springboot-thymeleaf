package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.ProductTypes;
import com.simple.pos.simplepointofsale.repository.ProductTypesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductTypesServiceImpl implements ProductTypesService {

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
    public List<ProductTypes> getAllProductTypesAscDesc(String ascDesc) {
        List<ProductTypes> lProductTypes = new ArrayList<>();
        
        if(ascDesc.equalsIgnoreCase("asc")){
            lProductTypes = productTypesRepository.findAllByOrderByProductTypeCodeAsc();
        }else if(ascDesc.equalsIgnoreCase("desc")){
            lProductTypes = productTypesRepository.findAllByOrderByProductTypeCodeDesc();
        }

        return lProductTypes;
    }
}
