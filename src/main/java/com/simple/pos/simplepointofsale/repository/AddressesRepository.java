package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.Addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long>{
    
}
