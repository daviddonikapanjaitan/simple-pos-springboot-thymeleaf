package com.simple.pos.simplepointofsale.Dto;

public class ProductTypesDto {
 
    private String producTypeCode;
    private String productTypeDescription;

    public ProductTypesDto(){
        
    }

    public ProductTypesDto(String producTypeCode, String productTypeDescription) {
        super();
        this.producTypeCode = producTypeCode;
        this.productTypeDescription = productTypeDescription;
    }

    public String getProducTypeCode() {
        return producTypeCode;
    }

    public void setProducTypeCode(String producTypeCode) {
        this.producTypeCode = producTypeCode;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    @Override
    public String toString() {
        return "ProductTypesDto [producTypeCode=" + producTypeCode + ", productTypeDescription="
                + productTypeDescription + "]";
    }
}
