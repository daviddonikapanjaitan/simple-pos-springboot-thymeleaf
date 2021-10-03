package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Addresses;

import org.springframework.data.domain.Pageable;

public interface AddressesService {
    
    List<Addresses> getAllAddresses();
    void saveAddresses(Addresses customer);
    Addresses getAddressesById(Long id);
    void deleteAddressesById(Long id);
    List<Addresses> getAllAddressesAscDesc(Pageable pageable);
    int getSize();
}
