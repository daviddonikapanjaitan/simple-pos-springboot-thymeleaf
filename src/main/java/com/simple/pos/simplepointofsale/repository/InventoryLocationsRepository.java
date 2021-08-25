package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.InventoryLocations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLocationsRepository extends JpaRepository<InventoryLocations, Long>{
    
}
