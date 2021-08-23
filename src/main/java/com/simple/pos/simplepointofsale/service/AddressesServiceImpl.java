package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Addresses;
import com.simple.pos.simplepointofsale.repository.AddressesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressesServiceImpl implements AddressesService{

    @Autowired
    private AddressesRepository addressesRepository;

    @Override
    public List<Addresses> getAllAddresses() {
        return addressesRepository.findAll();
    }

    @Override
    public void saveAddresses(Addresses addresses) {
        this.addressesRepository.save(addresses);
    }

    @Override
    public Addresses getAddressesById(Long id) {
        Optional<Addresses> optional = addressesRepository.findById(id);
        Addresses addresses = null;
        if(optional.isPresent()){
            addresses = optional.get();
        }else{
            throw new RuntimeException("Customer Address not found for id :: " + id);
        }
        
        return addresses;
    }

    @Override
    public void deleteAddressesById(Long id) {
        this.addressesRepository.deleteById(id);
    }
}
