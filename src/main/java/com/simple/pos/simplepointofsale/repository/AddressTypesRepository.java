package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.AddressTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypesRepository extends JpaRepository<AddressTypes, Long>{
    
}
