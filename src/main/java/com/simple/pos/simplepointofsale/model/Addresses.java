package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "line_1")
    private String line1;

    @Column(name = "line_2")
    private String line2;

    @Column(name = "line_3")
    private String line3;

    @Column(name = "line_4")
    private String line4;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_postcode")
    private String zipPostcode;

    @Column(name = "state_province_county")
    private String stateProvinceCounty;

    @Column(name = "county")
    private String county;

    @Column(name = "otherAddressDetails")
    private String otherAddressDetails;

    public Addresses(){

    }

    public Addresses(String line1, String line2, String line3, String line4, String city, String zipPostcode,
            String stateProvinceCounty, String county, String otherAddressDetails) {
        super();
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.city = city;
        this.zipPostcode = zipPostcode;
        this.stateProvinceCounty = stateProvinceCounty;
        this.county = county;
        this.otherAddressDetails = otherAddressDetails;
    }

    @Override
    public String toString() {
        return "Addresses [addressId=" + addressId + ", city=" + city + ", county=" + county + ", line1=" + line1
                + ", line2=" + line2 + ", line3=" + line3 + ", line4=" + line4 + ", otherAddressDetails="
                + otherAddressDetails + ", stateProvinceCounty=" + stateProvinceCounty + ", zipPostcode=" + zipPostcode
                + "]";
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getOtherAddressDetails() {
        return otherAddressDetails;
    }

    public void setOtherAddressDetails(String otherAddressDetails) {
        this.otherAddressDetails = otherAddressDetails;
    }
}
