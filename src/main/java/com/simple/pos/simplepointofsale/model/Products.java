package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_type_code")
    private String productTypeCode;

    @Column(name = "product_details")
    private String productDetails;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Long productPrice;

    @Column(name = "product_description")
    private String productDescription;

    public Long getProducstId() {
        return productId;
    }

    public Products(){
        
    }

    public Products(String productTypeCode, String productDetails, String productName, Long productPrice,
            String productDescription) {
        super();
        this.productTypeCode = productTypeCode;
        this.productDetails = productDetails;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
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
        return "Products [producstId=" + productId + ", productDescription=" + productDescription + ", productDetails="
                + productDetails + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productTypeCode=" + productTypeCode + "]";
    }
}
