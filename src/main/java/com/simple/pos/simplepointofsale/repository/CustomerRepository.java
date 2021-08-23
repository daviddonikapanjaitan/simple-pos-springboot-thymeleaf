package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
