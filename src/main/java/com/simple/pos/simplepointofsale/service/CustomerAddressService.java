package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.CustomerAddresses;

public interface CustomerAddressService {
    
    List<CustomerAddresses> getAllCustomersAddress();
    void saveCustomerAddress(CustomerAddresses customer);
    CustomerAddresses getCustomerAddressById(Long id);
    void deleteCustomerAddressById(Long id);
}
