package com.simple.pos.simplepointofsale.validationService;

public interface ValidationUtilsService {
    
    boolean validateEmail(String emailStr);
    boolean checkPaymentMethod(String paymentCode);
    boolean phoneValidation(String phone);
    boolean checkProductTypes(String productTypes);
    boolean checkProductId(String productId);
    boolean checkSupplierCode(String supplierCode);
    boolean checkCustomerId(Long customerId);
    boolean checkAddressId(Long addressId);
    boolean checkAddressTypeCode(String addressTypeCode);
}
