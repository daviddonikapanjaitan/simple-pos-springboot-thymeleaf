package com.simple.pos.simplepointofsale.Dto;

public class ProductsDto {
    
    private Long productIdTypeCode;
    private String productDetails;
    private String productName;
    private Long productPrice;
    private Long productDescription;

    public ProductsDto(){

    }

    public ProductsDto(Long productIdTypeCode, String productDetails, String productName, Long productPrice,
            Long productDescription) {
        super();
        this.productIdTypeCode = productIdTypeCode;
        this.productDetails = productDetails;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "ProductsDto [productDescription=" + productDescription + ", productDetails=" + productDetails
                + ", productIdTypeCode=" + productIdTypeCode + ", productName=" + productName + ", productPrice="
                + productPrice + "]";
    }

    public Long getProductIdTypeCode() {
        return productIdTypeCode;
    }
    public void setProductIdTypeCode(Long productIdTypeCode) {
        this.productIdTypeCode = productIdTypeCode;
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
    public Long getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
    public Long getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(Long productDescription) {
        this.productDescription = productDescription;
    }
}
