package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.BasketItems;
import com.simple.pos.simplepointofsale.repository.BasketItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketItemsServiceImpl implements BasketItemsService{

    @Autowired
    private BasketItemsRepository basketItemsRepository;

    @Override
    public List<BasketItems> getAllAddresses() {
        return basketItemsRepository.findAll();
    }

    @Override
    public void saveAddresses(BasketItems basketItems) {
        this.basketItemsRepository.save(basketItems);
    }

    @Override
    public BasketItems getAddressesById(Long id) {
        Optional<BasketItems> optional = basketItemsRepository.findById(id);
        BasketItems basketItems = null;
        if(optional.isPresent()){
            basketItems = optional.get();
        }else{
            throw new RuntimeException("Basket Items not found for id :: " + id);
        }
    
        return basketItems;
    }

    @Override
    public void deleteAddressesById(Long id) {
        this.basketItemsRepository.deleteById(id);
    }
}
