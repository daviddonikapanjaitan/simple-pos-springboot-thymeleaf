package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductsRepository extends JpaRepository<Products, Long>{
    
}
