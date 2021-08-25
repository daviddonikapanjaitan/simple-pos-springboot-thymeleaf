package com.simple.pos.simplepointofsale.Dto;

import java.util.Date;


public class SupplierLocationDto{

    private String supplierCode;
    private Long addressId;
    private Date dateFrom;
    private Date dateTo;

    public SupplierLocationDto(){

    }
    
    public SupplierLocationDto(String supplierCode, Long addressId, Date dateFrom, Date dateTo) {
        super();
        this.supplierCode = supplierCode;
        this.addressId = addressId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    public String getSupplierCode() {
        return supplierCode;
    }
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    public Long getAddressId() {
        return addressId;
    }
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
        return "SupplierLocationDto [addressId=" + addressId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
                + ", supplierCode=" + supplierCode + "]";
    }
}