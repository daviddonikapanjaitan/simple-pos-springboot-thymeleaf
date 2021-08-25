package com.simple.pos.simplepointofsale.repository;

import com.simple.pos.simplepointofsale.model.BasketItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemsRepository extends JpaRepository<BasketItems, Long>{
    
}
