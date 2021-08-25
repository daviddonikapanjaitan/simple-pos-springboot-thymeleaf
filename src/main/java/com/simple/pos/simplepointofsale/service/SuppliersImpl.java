package com.simple.pos.simplepointofsale.service;

import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.Suppliers;
import com.simple.pos.simplepointofsale.repository.SuppliersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersImpl implements SuppliersService{

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
}
