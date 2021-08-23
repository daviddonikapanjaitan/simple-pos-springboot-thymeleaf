package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.CustomerAddresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddresses, Long>{
    
}
