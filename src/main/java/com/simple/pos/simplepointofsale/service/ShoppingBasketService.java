package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.ShoppingBasket;

import org.springframework.data.domain.Pageable;

public interface ShoppingBasketService {
    
    List<ShoppingBasket> getAllShoppingBaskets();
    void saveShoppingBasket(ShoppingBasket customer);
    ShoppingBasket getShoppingBasketById(Long id);
    void deleteShoppingBasketById(Long id);
    List<ShoppingBasket> getAllShoppingBasketsAscDesc(Pageable pageable);
    int getSize();
}
