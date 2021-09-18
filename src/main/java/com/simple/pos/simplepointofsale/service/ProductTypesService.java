package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.ProductTypes;

public interface ProductTypesService {
    
    List<ProductTypes> getAllProductTypes();
    void saveProductTypes(ProductTypes productTypes);
    ProductTypes getProductTypesById(Long id);
    void deleteProductTypes(Long id);
    List<ProductTypes> getAllProductTypesAscDesc(String ascDesc);
}
