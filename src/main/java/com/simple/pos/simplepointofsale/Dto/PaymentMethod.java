package com.simple.pos.simplepointofsale.Dto;

public class PaymentMethod {
    
    private Long paymentMethodId;
    private String paymentMethodCode;
    private String paymentMethodDescription;

    public PaymentMethod(){

    }

    public PaymentMethod(String paymentMethodCode, String paymentMethodDescription) {
        super();
        this.paymentMethodCode = paymentMethodCode;
        this.paymentMethodDescription = paymentMethodDescription;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }
    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }
    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }
    public String getPaymentMethodDescription() {
        return paymentMethodDescription;
    }
    public void setPaymentMethodDescription(String paymentMethodDescription) {
        this.paymentMethodDescription = paymentMethodDescription;
    }
    @Override
    public String toString() {
        return "PaymentMethod [paymentMethodCode=" + paymentMethodCode + ", paymentMethodDescription="
                + paymentMethodDescription + ", paymentMethodId=" + paymentMethodId + "]";
    }
}
