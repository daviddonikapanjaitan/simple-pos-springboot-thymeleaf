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
    private String productTypeDescription;

    public ProductTypes(){

    }

    @Override
    public String toString() {
        return "ProductTypes [productTypeCode=" + productTypeCode + ", productTypeDescription=" + productTypeDescription
                + ", productTypeId=" + productTypeId + "]";
    }

    public ProductTypes(String productTypeCode, String productTypeDescription) {
        super();
        this.productTypeCode = productTypeCode;
        this.productTypeDescription = productTypeDescription;
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

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }
}
