package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.AddressTypes;

import org.springframework.data.domain.Pageable;

public interface AddressTypesService {
    
    List<AddressTypes> getAllAddressTypes();
    void saveAddressTypes(AddressTypes customer);
    AddressTypes getAddressTypesById(Long id);
    void deleteAddressTypesById(Long id);
    List<AddressTypes> getAllAddressesTypesAscDesc(Pageable pageable);
    int getSize();
}
