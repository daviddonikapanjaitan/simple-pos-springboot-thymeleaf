package com.simple.pos.simplepointofsale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basket_items")
public class BasketItems {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketItemsId;

    @Column(name = "cusotmer_id")
    private String customerName;

    @Column(name = "basket_datetime")
    private Date basketDateTime;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "cost")
    private Long cost;

    public BasketItems(String customerName, Date basketDateTime, Long productId, Long quantity, Long cost) {
        super();
        this.customerName = customerName;
        this.basketDateTime = basketDateTime;
        this.productId = productId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public BasketItems(){

    }

    @Override
    public String toString() {
        return "BasketItems [basketDateTime=" + basketDateTime + ", basketItemsId=" + basketItemsId + ", cost=" + cost
                + ", customerName=" + customerName + ", productId=" + productId + ", quantity=" + quantity + "]";
    }

    public Long getBasketItemsId() {
        return basketItemsId;
    }

    public void setBasketItemsId(Long basketItemsId) {
        this.basketItemsId = basketItemsId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBasketDateTime() {
        return basketDateTime;
    }

    public void setBasketDateTime(Date basketDateTime) {
        this.basketDateTime = basketDateTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
