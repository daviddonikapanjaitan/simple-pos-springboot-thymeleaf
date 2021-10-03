package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Suppliers;
import com.simple.pos.simplepointofsale.repository.SuppliersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SuppliersImpl implements SuppliersService{

    private static Logger logger = LoggerFactory.getLogger(AddressTypesServiceImpl.class);

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Override
    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    @Override
    public void saveSuppliers(Suppliers suppliers) {
        this.suppliersRepository.save(suppliers);
    }

    @Override
    public Suppliers getSuppliersById(Long id) {
        Optional<Suppliers> optional = suppliersRepository.findById(id);
        Suppliers suppliers = null;
        if(optional.isPresent()){
            suppliers = optional.get();
        }else{
            throw new RuntimeException("Suppliers not found for id :: " + id);
        }

        return suppliers;
    }

    @Override
    public void deleteSuppliersById(Long id) {
        this.suppliersRepository.deleteById(id);
    }

    @Override
    public List<Suppliers> getAllSuppliersAscDesc(Pageable pageable) {
        List<Suppliers> lSuppliers = new ArrayList<>();
        logger.info("{}", lSuppliers.toString());

        lSuppliers = suppliersRepository.findAll(pageable).getContent();

        return lSuppliers;
    }

    @Override
    public int getSize() {
        return suppliersRepository.findAll().size();
    }
}
