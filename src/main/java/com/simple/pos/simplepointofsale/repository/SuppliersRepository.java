package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.Suppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long>{
    
}
