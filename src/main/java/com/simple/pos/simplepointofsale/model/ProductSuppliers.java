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
    private Long valueSuppliedToDate;

    @Column(name = "total_quantity_supplied_to_date")
    private Long totalQuantitySuppliedToDate;
    
    @Column(name = "first_item_supplied_date")
    private Date firstItemSuppliedDate;

    @Column(name = "last_item_supplied_date")
    private Date lastItemSuppliedDate;

    @Column(name = "delivery_lead_time")
    private Date deliveryLeadTime;

    @Column(name = "standard_price")
    private Long standardPrice;

    @Column(name = "percentage_discount")
    private Long percentageDiscount;

    @Column(name = "minimum_order_quantity")
    private Long minimumOrderQuantity;

    @Column(name = "maximum_order_quantity")
    private Long maximumOrderQuantity;

    @Column(name = "other_item_suppliers_details")
    private String otherItemSuppliersDetails;

    public ProductSuppliers(){

    }

    public ProductSuppliers(Long productId, String supplierCode, Long valueSuppliedToDate,
            Long totalQuantitySuppliedToDate, Date firstItemSuppliedDate, Date lastItemSuppliedDate,
            Date deliveryLeadTime, Long standardPrice, Long percentageDiscount, Long minimumOrderQuantity,
            Long maximumOrderQuantity, String otherItemSuppliersDetails) {
        super();
        this.productId = productId;
        this.supplierCode = supplierCode;
        this.valueSuppliedToDate = valueSuppliedToDate;
        this.totalQuantitySuppliedToDate = totalQuantitySuppliedToDate;
        this.firstItemSuppliedDate = firstItemSuppliedDate;
        this.lastItemSuppliedDate = lastItemSuppliedDate;
        this.deliveryLeadTime = deliveryLeadTime;
        this.standardPrice = standardPrice;
        this.percentageDiscount = percentageDiscount;
        this.minimumOrderQuantity = minimumOrderQuantity;
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

    public Long getValueSuppliedToDate() {
        return valueSuppliedToDate;
    }

    public void setValueSuppliedToDate(Long valueSuppliedToDate) {
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

    public Date getDeliveryLeadTime() {
        return deliveryLeadTime;
    }

    public void setDeliveryLeadTime(Date deliveryLeadTime) {
        this.deliveryLeadTime = deliveryLeadTime;
    }

    public Long getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Long standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Long getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Long percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public Long getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(Long minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
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
                + maximumOrderQuantity + ", minimumOrderQuantity=" + minimumOrderQuantity
                + ", otherItemSuppliersDetails=" + otherItemSuppliersDetails + ", percentageDiscount="
                + percentageDiscount + ", productId=" + productId + ", productSuppliersId=" + productSuppliersId
                + ", standardPrice=" + standardPrice + ", supplierCode=" + supplierCode
                + ", totalQuantitySuppliedToDate=" + totalQuantitySuppliedToDate + ", valueSuppliedToDate="
                + valueSuppliedToDate + "]";
    }
}
