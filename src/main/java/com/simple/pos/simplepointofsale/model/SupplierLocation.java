package com.simple.pos.simplepointofsale.model;

import java.util.Date;

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
    private Long addressId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    public SupplierLocation(){
        
    }

    public SupplierLocation(String supplierCode, Long addressId, Date dateFrom, Date dateTo) {
        super();
        this.supplierCode = supplierCode;
        this.addressId = addressId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

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
        return "SupplierLocation [addressId=" + addressId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
                + ", supplierCode=" + supplierCode + ", supplierLocationId=" + supplierLocationId + "]";
    }
}
