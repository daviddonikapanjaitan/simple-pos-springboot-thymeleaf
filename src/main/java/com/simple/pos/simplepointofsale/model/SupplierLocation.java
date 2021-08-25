package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier_Location")
public class SupplierLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierLocationId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "date_from")
    private String dateFrom;

    public SupplierLocation(){
        
    }

    public SupplierLocation(String supplierCode, String addressId, String dateFrom, String dateTo) {
        super();
        this.supplierCode = supplierCode;
        this.addressId = addressId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Column(name = "date_to")
    private String dateTo;

    

    public Long getSupplierLocationId() {
        return supplierLocationId;
    }

    public void setSupplierLocationId(Long supplierLocationId) {
        this.supplierLocationId = supplierLocationId;
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
        return "SupplierLocation [addressId=" + addressId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
                + ", supplierCode=" + supplierCode + ", supplierLocationId=" + supplierLocationId + "]";
    }
}
