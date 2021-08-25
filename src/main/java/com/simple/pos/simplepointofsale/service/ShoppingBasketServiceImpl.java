package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.ShoppingBasket;
import com.simple.pos.simplepointofsale.repository.ShoppingBasketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService{

    @Autowired
    private ShoppingBasketRepository shoppingBasketRepository;

    @Override
    public List<ShoppingBasket> getAllShoppingBaskets() {
        return shoppingBasketRepository.findAll();
    }

    @Override
    public void saveShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasketRepository.save(shoppingBasket);
    }

    @Override
    public ShoppingBasket getShoppingBasketById(Long id) {
        Optional<ShoppingBasket> optional = shoppingBasketRepository.findById(id);
        ShoppingBasket shoppingBasket = null;
        if(optional.isPresent()){
            shoppingBasket = optional.get();
        }else{
            throw new RuntimeException("Customer Address not found for id :: " + id);
        }
        
        return shoppingBasket;
    }

    @Override
    public void deleteShoppingBasketById(Long id) {
        this.shoppingBasketRepository.deleteById(id);
    }
}
