package com.simple.pos.simplepointofsale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Shopping_Basket")
public class ShoppingBasket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingBasketId;

    @Column(name = "cusotmer_id")
    private String customerId;

    @Column(name = "basket_datetime")
    private Date basketDateTime;

    @Column(name = "total_cost")
    private Long totalCost;

    @Column(name = "other_basket_details")
    private String otherBasketDetails;

    public Long getShoppingBasketId() {
        return shoppingBasketId;
    }

    public void setShoppingBasketId(Long shoppingBasketId) {
        this.shoppingBasketId = shoppingBasketId;
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

    public ShoppingBasket(){

    }

    public ShoppingBasket(String customerId, Date basketDateTime, Long totalCost, String otherBasketDetails) {
        super();
        this.customerId = customerId;
        this.basketDateTime = basketDateTime;
        this.totalCost = totalCost;
        this.otherBasketDetails = otherBasketDetails;
    }

    @Override
    public String toString() {
        return "ShoppingBasket [basketDateTime=" + basketDateTime + ", customerId=" + customerId
                + ", otherBasketDetails=" + otherBasketDetails + ", shoppingBasketId=" + shoppingBasketId
                + ", totalCost=" + totalCost + "]";
    }
}
