package com.simple.pos.simplepointofsale.Dto;


public class ShoppingBasketDto {
    
    private String customerId;
    private String basketDateTime;
    private Long totalCost;
    private String otherBasketDetails;

    public ShoppingBasketDto(String customerId, String basketDateTime, Long totalCost, String otherBasketDetails) {
        super();
        this.customerId = customerId;
        this.basketDateTime = basketDateTime;
        this.totalCost = totalCost;
        this.otherBasketDetails = otherBasketDetails;
    }

    public ShoppingBasketDto(){

    }

    @Override
    public String toString() {
        return "ShoppingBasket [basketDateTime=" + basketDateTime + ", customerId=" + customerId
                + ", otherBasketDetails=" + otherBasketDetails + ", totalCost=" + totalCost + "]";
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getBasketDateTime() {
        return basketDateTime;
    }
    public void setBasketDateTime(String basketDateTime) {
        this.basketDateTime = basketDateTime;
    }
    public Long getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }
    public String getOtherBasketDetails() {
        return otherBasketDetails;
    }
    public void setOtherBasketDetails(String otherBasketDetails) {
        this.otherBasketDetails = otherBasketDetails;
    }
}
