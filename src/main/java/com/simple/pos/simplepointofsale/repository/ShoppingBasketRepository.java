package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.ShoppingBasket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long>{
    
}
