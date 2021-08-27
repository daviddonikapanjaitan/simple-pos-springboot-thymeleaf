package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.AddressTypes;

public interface AddressTypesService {
    
    List<AddressTypes> getAllAddressTypes();
    void saveAddressTypes(AddressTypes customer);
    AddressTypes getAddressTypesById(Long id);
    void deleteAddressTypesById(Long id);
}
