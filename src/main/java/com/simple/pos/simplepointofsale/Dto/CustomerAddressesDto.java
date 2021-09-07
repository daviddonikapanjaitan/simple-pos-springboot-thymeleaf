package com.simple.pos.simplepointofsale.Dto;

public class CustomerAddressesDto {

    private String customerId;
    private String addressId;
    private String addressTypeCode;
    private String dateFrom;
    private String dateTo;

    public CustomerAddressesDto(){

    }

    public CustomerAddressesDto(String customerId, String addressId, String addressTypeCode,
        String dateFrom, String dateTo) {
        super();
        this.customerId = customerId;
        this.addressId = addressId;
        this.addressTypeCode = addressTypeCode;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }


    public void setAddressTypeCode(String addressTypeCode){
        this.addressTypeCode = addressTypeCode;
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
        return "CustomerAddressesDto [addressId=" + addressId + ", addressTypeCode=" + addressTypeCode + ", customerId="
                + customerId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
    }
}
