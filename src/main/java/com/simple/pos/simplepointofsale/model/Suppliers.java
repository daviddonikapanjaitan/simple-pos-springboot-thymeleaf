package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Suppliers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suppliersId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_email")
    private String supplierEmail;

    @Column(name = "supplier_phone")
    private String supplierPhone;

    @Column(name = "other_supplier_details")
    private String otherSupplierDetails;

    public Suppliers(){

    }

    public Suppliers(String supplierCode, String supplierName, String supplierAddress, String supplierEmail,
            String supplierPhone, String otherSupplierDetails) {
        super();
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
        this.otherSupplierDetails = otherSupplierDetails;
    }

    public Long getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Long suppliersId) {
        this.suppliersId = suppliersId;
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
        return "Suppliers [otherSupplierDetails=" + otherSupplierDetails + ", supplierAddress=" + supplierAddress
                + ", supplierCode=" + supplierCode + ", supplierEmail=" + supplierEmail + ", supplierName="
                + supplierName + ", supplierPhone=" + supplierPhone + ", suppliersId=" + suppliersId + "]";
    }
}
