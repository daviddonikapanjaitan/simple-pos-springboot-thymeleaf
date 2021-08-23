package com.simple.pos.simplepointofsale.service;

import java.util.List;

import com.simple.pos.simplepointofsale.model.PaymentMethod;
 
public interface PaymentMethodService {
    
    List<PaymentMethod> getAllPaymentMethod();
    void savePaymentMethod(PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethodById(Long id);
    void deletePaymentMethod(Long id);
}
