package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.ProductSuppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSuppliersRepository extends JpaRepository<ProductSuppliers, Long>{
    
}
