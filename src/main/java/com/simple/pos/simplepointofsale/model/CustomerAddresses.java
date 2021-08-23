package com.simple.pos.simplepointofsale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Addresses")
public class CustomerAddresses{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerAddressId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_type_code")
    private Long addressTypeCode;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    public CustomerAddresses(){
        
    }

    @Override
    public String toString() {
        return "CustomerAddresses [addressId=" + addressId + ", addressTypeCode=" + addressTypeCode
                + ", customerAddressId=" + customerAddressId + ", customerId=" + customerId + ", dateFrom=" + dateFrom
                + ", dateTo=" + dateTo + "]";
    }

    public CustomerAddresses(Long customerId, Long addressId, Long addressTypeCode, Date dateFrom, Date dateTo) {
        super();
        this.customerId = customerId;
        this.addressId = addressId;
        this.addressTypeCode = addressTypeCode;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(Long customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(Long addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}