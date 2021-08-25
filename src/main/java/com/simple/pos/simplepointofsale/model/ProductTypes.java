package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductTypes")
public class ProductTypes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productTypeId;

    @Column(name = "product_type_code")
    private String productTypeCode;

    @Column(name = "product_type_description")
    private String productTypeDecription;

    public ProductTypes(){

    }

    @Override
    public String toString() {
        return "ProductTypes [productTypeCode=" + productTypeCode + ", productTypeDecription=" + productTypeDecription
                + ", productTypeId=" + productTypeId + "]";
    }

    public ProductTypes(String productTypeCode, String productTypeDecription) {
        super();
        this.productTypeCode = productTypeCode;
        this.productTypeDecription = productTypeDecription;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeDecription() {
        return productTypeDecription;
    }

    public void setProductTypeDecription(String productTypeDecription) {
        this.productTypeDecription = productTypeDecription;
    }
}
