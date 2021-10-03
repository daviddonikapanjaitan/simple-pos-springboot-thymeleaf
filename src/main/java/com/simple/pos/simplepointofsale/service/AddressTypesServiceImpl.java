package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.AddressTypes;
import com.simple.pos.simplepointofsale.repository.AddressTypesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressTypesServiceImpl implements AddressTypesService{

    private static Logger logger = LoggerFactory.getLogger(AddressTypesServiceImpl.class);

    @Autowired
    private AddressTypesRepository addressTypesRepository;

    @Override
    public List<AddressTypes> getAllAddressTypes() {
        return addressTypesRepository.findAll();
    }

    @Override
    public void saveAddressTypes(AddressTypes addressTypes) {
        this.addressTypesRepository.save(addressTypes);
    }

    @Override
    public AddressTypes getAddressTypesById(Long id) {
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
    public void deleteAddressTypesById(Long id) {
        this.addressTypesRepository.deleteById(id);
    }

    @Override
    public List<AddressTypes> getAllAddressesTypesAscDesc(Pageable pageable) {
        List<AddressTypes> lAddressTypes = new ArrayList<>();
        logger.info("{}", lAddressTypes.toString());

        lAddressTypes = addressTypesRepository.findAll(pageable).getContent();

        return lAddressTypes;
    }

    @Override
    public int getSize() {
        return addressTypesRepository.findAll().size();
    }
}
