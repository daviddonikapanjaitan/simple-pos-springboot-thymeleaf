package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.BasketItems;

public interface BasketItemsService {
    
    List<BasketItems> getAllBasketItems();
    void saveBasketItems(BasketItems BasketItems);
    BasketItems getBasketItemsById(Long id);
    void deleteBasketItemsById(Long id);
}
