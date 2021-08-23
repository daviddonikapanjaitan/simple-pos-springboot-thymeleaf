package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{
    
}
