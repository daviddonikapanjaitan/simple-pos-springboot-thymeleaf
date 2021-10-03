package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.CustomerAddresses;
import com.simple.pos.simplepointofsale.repository.CustomerAddressRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService{

    private static Logger logger = LoggerFactory.getLogger(AddressTypesServiceImpl.class);

    @Autowired
    private CustomerAddressRepository customerAddressRepository;
    
    @Override
    public List<CustomerAddresses> getAllCustomersAddress() {
        return customerAddressRepository.findAll();
    }

    @Override
    public void saveCustomerAddress(CustomerAddresses customer) {
        this.customerAddressRepository.save(customer);
    }

    @Override
    public CustomerAddresses getCustomerAddressById(Long id) {
        Optional<CustomerAddresses> optional = customerAddressRepository.findById(id);
        CustomerAddresses customerAddresses = null;
        if(optional.isPresent()){
            customerAddresses = optional.get();
        }else{
            throw new RuntimeException("Customer Address not found for id :: " + id);
        }
        
        return customerAddresses;
    }

    @Override
    public void deleteCustomerAddressById(Long id) {
        this.customerAddressRepository.deleteById(id);
    }

    @Override
    public List<CustomerAddresses> getAllCustomerAddressAscDesc(Pageable pageable) {
        List<CustomerAddresses> lCustomerAddresses = new ArrayList<>();
        logger.info("{}", lCustomerAddresses.toString());

        lCustomerAddresses = customerAddressRepository.findAll(pageable).getContent();

        return lCustomerAddresses;
    }

    @Override
    public int getSize() {
        return customerAddressRepository.findAll().size();
    }
}
