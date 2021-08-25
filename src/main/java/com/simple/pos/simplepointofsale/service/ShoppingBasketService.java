package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.ShoppingBasket;

public interface ShoppingBasketService {
    
    List<ShoppingBasket> getAllShoppingBaskets();
    void saveShoppingBasket(ShoppingBasket customer);
    ShoppingBasket getShoppingBasketById(Long id);
    void deleteShoppingBasketById(Long id);
}
