package com.simple.pos.simplepointofsale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    
    @Column(name = "payment_method_code")
    private String paymentMethodCode;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "date_become_customer")
    private Date dateBecomeCustomer;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "other_customer_details")
    private String otherCustomerDetails;

    

    public Customer(String paymentMethodCode, String customerName, String customerPhone,
            String customerEmail, Date dateBecomeCustomer, String paymentDetails, String otherCustomerDetails) {
        super();
        this.paymentMethodCode = paymentMethodCode;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.dateBecomeCustomer = dateBecomeCustomer;
        this.paymentDetails = paymentDetails;
        this.otherCustomerDetails = otherCustomerDetails;
    }

    public Customer(){

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getDateBecomeCustomer() {
        return dateBecomeCustomer;
    }

    public void setDateBecomeCustomer(Date dateBecomeCustomer) {
        this.dateBecomeCustomer = dateBecomeCustomer;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getOtherCustomerDetails() {
        return otherCustomerDetails;
    }

    public void setOtherCustomerDetails(String otherCustomerDetails) {
        this.otherCustomerDetails = otherCustomerDetails;
    }

    @Override
    public String toString() {
        return "Customer [customerEmail=" + customerEmail + ", customerId=" + customerId + ", customerName="
                + customerName + ", customerPhone=" + customerPhone + ", dateBecomeCustomer=" + dateBecomeCustomer
                + ", otherCustomerDetails=" + otherCustomerDetails + ", paymentDetails=" + paymentDetails
                + ", paymentMethodCode=" + paymentMethodCode + "]";
    }
}
