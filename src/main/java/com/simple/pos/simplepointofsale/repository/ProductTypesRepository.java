package com.simple.pos.simplepointofsale.repository;

import java.util.List;
import com.simple.pos.simplepointofsale.model.ProductTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypesRepository extends JpaRepository<ProductTypes, Long>{
    
    public List<ProductTypes> findAllByOrderByProductTypeCodeAsc();

    public List<ProductTypes> findAllByOrderByProductTypeCodeDesc();
}