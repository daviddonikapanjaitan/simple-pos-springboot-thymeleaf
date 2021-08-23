package com.simple.pos.simplepointofsale.Dto;

import java.util.Date;

public class CustomerAddressesDto {

    private Long customerAddressId;
    private Long customerId;
    private Long addressId;
    private Long addressTypeCode;
    private Date dateFrom;
    private Date dateTo;

    public CustomerAddressesDto(){

    }

    public CustomerAddressesDto(Long customerId, Long addressId, Long addressTypeCode,
            Date dateFrom, Date dateTo) {
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

    @Override
    public String toString() {
        return "CustomerAddressesDto [addressId=" + addressId + ", addressTypeCode=" + addressTypeCode
                + ", customerAddressId=" + customerAddressId + ", customerId=" + customerId + ", dateFrom=" + dateFrom
                + ", dateTo=" + dateTo + "]";
    }
}
