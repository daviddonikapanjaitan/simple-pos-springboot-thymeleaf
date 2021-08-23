package com.simple.pos.simplepointofsale.Dto;

public class AddressTypesDto {
    
    private String addressTypeCode;
    private String addressTypeDescription;
    
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

    public AddressTypesDto(){

    }

    public AddressTypesDto(String addressTypeCode, String addressTypeDescription) {
        super();
        this.addressTypeCode = addressTypeCode;
        this.addressTypeDescription = addressTypeDescription;
    }

    @Override
    public String toString() {
        return "AddressTypesDto [addressTypeCode=" + addressTypeCode + ", addressTypeDescription="
                + addressTypeDescription + "]";
    }
}
