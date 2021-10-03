package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Addresses;
import com.simple.pos.simplepointofsale.repository.AddressesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressesServiceImpl implements AddressesService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

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

    @Override
    public List<Addresses> getAllAddressesAscDesc(Pageable pageable) {
        List<Addresses> lAddresses = new ArrayList<>();
        logger.info("{}", lAddresses.toString());

        lAddresses = addressesRepository.findAll(pageable).getContent();

        return lAddresses;
    }

    @Override
    public int getSize() {
        return addressesRepository.findAll().size();
    }
}
