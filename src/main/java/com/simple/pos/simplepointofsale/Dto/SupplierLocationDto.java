package com.simple.pos.simplepointofsale.Dto;

public class SupplierLocationDto{

    private String supplierCode;
    private String addressId;
    private String dateFrom;
    private String dateTo;
    
    public SupplierLocationDto(){

    }
    
    public SupplierLocationDto(String supplierCode, String addressId, String dateFrom, String dateTo) {
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
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    public String getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
    public String getDateTo() {
        return dateTo;
    }
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "SupplierLocationDto [addressId=" + addressId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
                + ", supplierCode=" + supplierCode + "]";
    }
}