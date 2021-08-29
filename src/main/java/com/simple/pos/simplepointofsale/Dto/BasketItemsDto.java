package com.simple.pos.simplepointofsale.Dto;

public class BasketItemsDto {
    
    private Long customerId;
    private String basketDateTime;
    private Long productId;
    private Long quantity;
    private Long cost;
    
    public BasketItemsDto(){

    }

    public BasketItemsDto(Long customerId, String basketDateTime, Long productId, Long quantity, Long cost) {
        this.customerId = customerId;
        this.basketDateTime = basketDateTime;
        this.productId = productId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getBasketDateTime() {
        return basketDateTime;
    }

    public void setBasketDateTime(String basketDateTime) {
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

    @Override
    public String toString() {
        return "BasketItemsDto [basketDateTime=" + basketDateTime + ", cost=" + cost + ", customerId=" + customerId
                + ", productId=" + productId + ", quantity=" + quantity + "]";
    }
}
