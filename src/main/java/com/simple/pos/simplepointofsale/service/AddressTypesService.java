package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.AddressTypes;

public interface AddressTypesService {
    
    List<AddressTypes> getAllCustomersAddress();
    void saveCustomerAddress(AddressTypes customer);
    AddressTypes getCustomerAddressById(Long id);
    void deleteCustomerAddressById(Long id);
}
