package com.simple.pos.simplepointofsale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simple.pos.simplepointofsale.model.PaymentMethod;
import com.simple.pos.simplepointofsale.repository.PaymentMethodRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

    private static Logger logger = LoggerFactory.getLogger(ProductTypesServiceImpl.class);

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void savePaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethodById(Long id) {
        Optional<PaymentMethod> optional = paymentMethodRepository.findById(id);
        PaymentMethod paymentMethod = null;

        if(optional.isPresent()){
            paymentMethod = optional.get();
        }else{
            throw new RuntimeException("Payment Method not found for id :: " + id);
        }
        return paymentMethod;
    }

    @Override
    public void deletePaymentMethod(Long id) {
        this.paymentMethodRepository.deleteById(id);
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethodAscDesc(Pageable pageable) {
        List<PaymentMethod> lPaymentMethods = new ArrayList<>();
        logger.info("{}", lPaymentMethods.toString());

        lPaymentMethods = paymentMethodRepository.findAll(pageable).getContent();

        return lPaymentMethods;
    }

    @Override
    public int getSize() {
        return paymentMethodRepository.findAll().size();
    }
}
