package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.BasketItems;
import com.simple.pos.simplepointofsale.repository.BasketItemsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BasketItemsServiceImpl implements BasketItemsService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

    @Autowired
    private BasketItemsRepository basketItemsRepository;

    @Override
    public List<BasketItems> getAllBasketItems() {
        return basketItemsRepository.findAll();
    }

    @Override
    public void saveBasketItems(BasketItems basketItems) {
        this.basketItemsRepository.save(basketItems);
    }

    @Override
    public BasketItems getBasketItemsById(Long id) {
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
    public void deleteBasketItemsById(Long id) {
        this.basketItemsRepository.deleteById(id);
    }

    @Override
    public List<BasketItems> getAllBasketItemsAscDesc(Pageable pageable) {
        List<BasketItems> lBasketItems = new ArrayList<>();
        logger.info("{}", lBasketItems.toString());

        lBasketItems = basketItemsRepository.findAll(pageable).getContent();

        return lBasketItems;
    }

    @Override
    public int getSize() {
        return basketItemsRepository.findAll().size();
    }
}
