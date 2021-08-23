package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Addresses;

public interface AddressesService {
    
    List<Addresses> getAllAddresses();
    void saveAddresses(Addresses customer);
    Addresses getAddressesById(Long id);
    void deleteAddressesById(Long id);
}
