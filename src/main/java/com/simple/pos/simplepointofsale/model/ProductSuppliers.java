package com.simple.pos.simplepointofsale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductSuppliers")
public class ProductSuppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSuppliersId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "value_supplied_to_date")
    private Date valueSuppliedToDate;

    @Column(name = "total_quantity_supplied_to_date")
    private Long totalQuantitySuppliedToDate;
    
    @Column(name = "first_item_supplied_date")
    private Date firstItemSuppliedDate;

    @Column(name = "last_item_supplied_date")
    private Date lastItemSuppliedDate;

    @Column(name = "delivery_lead_time")
    private Long deliveryLeadTime;

    @Column(name = "standard_price")
    private Long standardPrice;

    @Column(name = "percentage_discount_minimum_order_quantity")
    private Long percentageDiscountMinimumOrderQuantity;

    @Column(name = "maximum_order_quantity")
    private Long maximumOrderQuantity;

    @Column(name = "other_item_suppliers_details")
    private String otherItemSuppliersDetails;

    public ProductSuppliers(){

    }

    public ProductSuppliers(Long productId, String supplierCode, Date valueSuppliedToDate,
            Long totalQuantitySuppliedToDate, Date firstItemSuppliedDate, Date lastItemSuppliedDate,
            Long deliveryLeadTime, Long standardPrice, Long percentageDiscountMinimumOrderQuantity,
            Long maximumOrderQuantity, String otherItemSuppliersDetails) {
        this.productId = productId;
        this.supplierCode = supplierCode;
        this.valueSuppliedToDate = valueSuppliedToDate;
        this.totalQuantitySuppliedToDate = totalQuantitySuppliedToDate;
        this.firstItemSuppliedDate = firstItemSuppliedDate;
        this.lastItemSuppliedDate = lastItemSuppliedDate;
        this.deliveryLeadTime = deliveryLeadTime;
        this.standardPrice = standardPrice;
        this.percentageDiscountMinimumOrderQuantity = percentageDiscountMinimumOrderQuantity;
        this.maximumOrderQuantity = maximumOrderQuantity;
        this.otherItemSuppliersDetails = otherItemSuppliersDetails;
    }

    public Long getProductSuppliersId() {
        return productSuppliersId;
    }

    public void setProductSuppliersId(Long productSuppliersId) {
        this.productSuppliersId = productSuppliersId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Date getValueSuppliedToDate() {
        return valueSuppliedToDate;
    }

    public void setValueSuppliedToDate(Date valueSuppliedToDate) {
        this.valueSuppliedToDate = valueSuppliedToDate;
    }

    public Long getTotalQuantitySuppliedToDate() {
        return totalQuantitySuppliedToDate;
    }

    public void setTotalQuantitySuppliedToDate(Long totalQuantitySuppliedToDate) {
        this.totalQuantitySuppliedToDate = totalQuantitySuppliedToDate;
    }

    public Date getFirstItemSuppliedDate() {
        return firstItemSuppliedDate;
    }

    public void setFirstItemSuppliedDate(Date firstItemSuppliedDate) {
        this.firstItemSuppliedDate = firstItemSuppliedDate;
    }

    public Date getLastItemSuppliedDate() {
        return lastItemSuppliedDate;
    }

    public void setLastItemSuppliedDate(Date lastItemSuppliedDate) {
        this.lastItemSuppliedDate = lastItemSuppliedDate;
    }

    public Long getDeliveryLeadTime() {
        return deliveryLeadTime;
    }

    public void setDeliveryLeadTime(Long deliveryLeadTime) {
        this.deliveryLeadTime = deliveryLeadTime;
    }

    public Long getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Long standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Long getPercentageDiscountMinimumOrderQuantity() {
        return percentageDiscountMinimumOrderQuantity;
    }

    public void setPercentageDiscountMinimumOrderQuantity(Long percentageDiscountMinimumOrderQuantity) {
        this.percentageDiscountMinimumOrderQuantity = percentageDiscountMinimumOrderQuantity;
    }

    public Long getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(Long maximumOrderQuantity) {
        this.maximumOrderQuantity = maximumOrderQuantity;
    }

    public String getOtherItemSuppliersDetails() {
        return otherItemSuppliersDetails;
    }

    public void setOtherItemSuppliersDetails(String otherItemSuppliersDetails) {
        this.otherItemSuppliersDetails = otherItemSuppliersDetails;
    }

    @Override
    public String toString() {
        return "ProductSuppliers [deliveryLeadTime=" + deliveryLeadTime + ", firstItemSuppliedDate="
                + firstItemSuppliedDate + ", lastItemSuppliedDate=" + lastItemSuppliedDate + ", maximumOrderQuantity="
                + maximumOrderQuantity + ", otherItemSuppliersDetails=" + otherItemSuppliersDetails
                + ", percentageDiscountMinimumOrderQuantity=" + percentageDiscountMinimumOrderQuantity + ", productId="
                + productId + ", productSuppliersId=" + productSuppliersId + ", standardPrice=" + standardPrice
                + ", supplierCode=" + supplierCode + ", totalQuantitySuppliedToDate=" + totalQuantitySuppliedToDate
                + ", valueSuppliedToDate=" + valueSuppliedToDate + "]";
    }
}
