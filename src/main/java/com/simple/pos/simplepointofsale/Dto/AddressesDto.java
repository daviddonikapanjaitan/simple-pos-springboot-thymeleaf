package com.simple.pos.simplepointofsale.Dto;

public class AddressesDto {
    
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String city;
    private String zipPostcode;
    private String stateProvinceCounty;
    private String country;
    private String otherAddressDetails;

    public AddressesDto(){
        
    }

    @Override
    public String toString() {
        return "AddressesDto [city=" + city + ", country=" + country + ", line1=" + line1 + ", line2=" + line2
                + ", line3=" + line3 + ", line4=" + line4 + ", otherAddressDetails=" + otherAddressDetails
                + ", stateProvinceCounty=" + stateProvinceCounty + ", zipPostcode=" + zipPostcode + "]";
    }
    
    public AddressesDto(String line1, String line2, String line3, String line4, String city, String zipPostcode,
            String stateProvinceCounty, String country, String otherAddressDetails) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.city = city;
        this.zipPostcode = zipPostcode;
        this.stateProvinceCounty = stateProvinceCounty;
        this.country = country;
        this.otherAddressDetails = otherAddressDetails;
    }

    public String getLine1() {
        return line1;
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public String getLine2() {
        return line2;
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public String getLine3() {
        return line3;
    }
    public void setLine3(String line3) {
        this.line3 = line3;
    }
    public String getLine4() {
        return line4;
    }
    public void setLine4(String line4) {
        this.line4 = line4;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipPostcode() {
        return zipPostcode;
    }
    public void setZipPostcode(String zipPostcode) {
        this.zipPostcode = zipPostcode;
    }
    public String getStateProvinceCounty() {
        return stateProvinceCounty;
    }
    public void setStateProvinceCounty(String stateProvinceCounty) {
        this.stateProvinceCounty = stateProvinceCounty;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getOtherAddressDetails() {
        return otherAddressDetails;
    }
    public void setOtherAddressDetails(String otherAddressDetails) {
        this.otherAddressDetails = otherAddressDetails;
    }
}
