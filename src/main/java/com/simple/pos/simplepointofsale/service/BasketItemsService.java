package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.BasketItems;

public interface BasketItemsService {
    
    List<BasketItems> getAllAddresses();
    void saveAddresses(BasketItems BasketItems);
    BasketItems getAddressesById(Long id);
    void deleteAddressesById(Long id);
}
