package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.ShoppingBasket;
import com.simple.pos.simplepointofsale.repository.ShoppingBasketRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService{

    private static Logger logger = LoggerFactory.getLogger(ShoppingBasketServiceImpl.class);

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

    @Override
    public List<ShoppingBasket> getAllShoppingBasketsAscDesc(Pageable pageable) {
        List<ShoppingBasket> lShoppingBaskets = new ArrayList<>();
        logger.info("{}", lShoppingBaskets.toString());

        lShoppingBaskets = shoppingBasketRepository.findAll(pageable).getContent();

        return lShoppingBaskets;
    }

    @Override
    public int getSize() {
        return shoppingBasketRepository.findAll().size();
    }
}
