package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.Customer;

import org.springframework.data.domain.Pageable;

public interface CustomerService {
    
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void deleteCustomerById(Long id);
    List<Customer> getAllCustomersAscDesc(Pageable pageable);
    int getSize();
}
