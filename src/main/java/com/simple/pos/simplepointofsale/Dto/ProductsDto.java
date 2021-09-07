package com.simple.pos.simplepointofsale.Dto;

public class ProductsDto {
    
    private String productTypeCode;
    private String productDetails;
    private String productName;
    private String productPrice;
    private String productDescription;

    public ProductsDto(){

    }

    public ProductsDto(String productTypeCode, String productDetails, String productName, String productPrice,
            String productDescription) {
        this.productTypeCode = productTypeCode;
        this.productDetails = productDetails;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "ProductsDto [productDescription=" + productDescription + ", productDetails=" + productDetails
                + ", productName=" + productName + ", productPrice=" + productPrice + ", productTypeCode="
                + productTypeCode + "]";
    }
}
