package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ref_Address_Types")
public class AddressTypes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressTypeId;

    @Column(name = "address_type_code")
    private String addressTypeCode;

    @Column(name = "address_type_description")
    private String addressTypeDescription;

    public AddressTypes(){

    }

    public AddressTypes(String addressTypeCode, String addressTypeDescription) {
        super();
        this.addressTypeCode = addressTypeCode;
        this.addressTypeDescription = addressTypeDescription;
    }

    @Override
    public String toString() {
        return "AddressTypes [addressTypeCode=" + addressTypeCode + ", addressTypeDescription=" + addressTypeDescription
                + ", addressTypeId=" + addressTypeId + "]";
    }

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getAddressTypeDescription() {
        return addressTypeDescription;
    }

    public void setAddressTypeDescription(String addressTypeDescription) {
        this.addressTypeDescription = addressTypeDescription;
    }
}