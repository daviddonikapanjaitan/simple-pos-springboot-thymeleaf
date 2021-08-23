package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ref_Payment_Methods")
public class PaymentMethod {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentMethodId;

    @Column(name = "payment_method_code")
    private String paymentMethodCode;

    @Column(name = "payment_method_description")
    private String paymentMethodDescription;

    public PaymentMethod(String paymentMethodCode, String paymentMethodDescription) {
        super();
        this.paymentMethodCode = paymentMethodCode;
        this.paymentMethodDescription = paymentMethodDescription;
    }

    public PaymentMethod(){

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
