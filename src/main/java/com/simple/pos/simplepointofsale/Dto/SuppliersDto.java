package com.simple.pos.simplepointofsale.Dto;

public class SuppliersDto {
    
    private String supplierCode;
    private String supplierName;
    private String supplierAddress;
    private String supplierEmail;
    private String supplierPhone;
    private String otherSupplierDetails;

    public SuppliersDto(){

    }

    public SuppliersDto(String supplierCode, String supplierName, String supplierAddress, String supplierEmail,
            String supplierPhone, String otherSupplierDetails) {
        super();
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
        this.otherSupplierDetails = otherSupplierDetails;
    }

    public String getSupplierCode() {
        return supplierCode;
    }
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getSupplierAddress() {
        return supplierAddress;
    }
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
    public String getSupplierEmail() {
        return supplierEmail;
    }
    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    public String getSupplierPhone() {
        return supplierPhone;
    }
    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
    public String getOtherSupplierDetails() {
        return otherSupplierDetails;
    }
    public void setOtherSupplierDetails(String otherSupplierDetails) {
        this.otherSupplierDetails = otherSupplierDetails;
    }

    @Override
    public String toString() {
        return "SuppliersDto [otherSupplierDetails=" + otherSupplierDetails + ", supplierAddress=" + supplierAddress
                + ", supplierCode=" + supplierCode + ", supplierEmail=" + supplierEmail + ", supplierName="
                + supplierName + ", supplierPhone=" + supplierPhone + "]";
    }
}
