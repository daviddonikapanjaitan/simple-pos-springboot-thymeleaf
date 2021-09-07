package com.simple.pos.simplepointofsale.validationService;

public interface ValidationUtilsService {
    
    boolean validateEmail(String emailStr);
    boolean checkPaymentMethod(String paymentCode);
    boolean phoneValidation(String phone);
}
