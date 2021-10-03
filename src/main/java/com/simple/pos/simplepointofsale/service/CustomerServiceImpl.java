package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Customer;
import com.simple.pos.simplepointofsale.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if(optional.isPresent()){
            customer = optional.get();
        }else{
            throw new RuntimeException("Employee not found for id :: " + id);
        }

        return customer;
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomersAscDesc(Pageable pageable) {
        List<Customer> lCustomers = new ArrayList<>();
        logger.info("{}", lCustomers.toString());

        lCustomers = customerRepository.findAll(pageable).getContent();

        return lCustomers;
    }

    @Override
    public int getSize() {
        return customerRepository.findAll().size();
    }
}
