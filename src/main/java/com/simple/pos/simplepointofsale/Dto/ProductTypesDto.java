package com.simple.pos.simplepointofsale.Dto;

public class ProductTypesDto {
 
    private String productTypeCode;
    private String productTypeDescription;

    public ProductTypesDto(){
        
    }

    public ProductTypesDto(String productTypeCode, String productTypeDescription) {
        this.productTypeCode = productTypeCode;
        this.productTypeDescription = productTypeDescription;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    @Override
    public String toString() {
        return "ProductTypesDto [productTypeCode=" + productTypeCode + ", productTypeDescription="
                + productTypeDescription + "]";
    }
}
