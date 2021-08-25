package com.simple.pos.simplepointofsale.Dto;

import java.util.Date;

public class BasketItemsDto {
    
    private String customerId;
    private Date basketDateTime;
    private Long productId;
    private Long quantity;
    private Long cost;
    
    public BasketItemsDto(){

    }

    @Override
    public String toString() {
        return "BasketItemsDto [basketDateTime=" + basketDateTime + ", cost=" + cost + ", customerId=" + customerId
                + ", productId=" + productId + ", quantity=" + quantity + "]";
    }

    public BasketItemsDto(String customerId, Date basketDateTime, Long productId, Long quantity, Long cost) {
        super();
        this.customerId = customerId;
        this.basketDateTime = basketDateTime;
        this.productId = productId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
