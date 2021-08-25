package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.SupplierLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierLocationRepository extends JpaRepository<SupplierLocation, Long>{
    
}
