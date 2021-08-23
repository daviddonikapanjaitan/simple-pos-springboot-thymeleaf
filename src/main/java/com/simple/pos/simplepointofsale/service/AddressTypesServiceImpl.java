package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.repository.AddressTypesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressTypesServiceImpl implements AddressTypesService{

    @Autowired
    private AddressTypesRepository addressTypesRepository;

    @Override
    public List<AddressTypes> getAllCustomersAddress() {
        return addressTypesRepository.findAll();
    }

    @Override
    public void saveCustomerAddress(AddressTypes addressTypes) {
        this.addressTypesRepository.save(addressTypes);
    }

    @Override
    public AddressTypes getCustomerAddressById(Long id) {
        Optional<AddressTypes> optional = addressTypesRepository.findById(id);
        AddressTypes addressTypes = null;
        if(optional.isPresent()){
            addressTypes = optional.get();
        }else{
            throw new RuntimeException("Customer Address not found for id :: " + id);
        }
        
        return addressTypes;
    }

    @Override
    public void deleteCustomerAddressById(Long id) {
        this.addressTypesRepository.deleteById(id);
    }
}
