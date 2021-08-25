package com.simple.pos.simplepointofsale.Dto;

import java.util.Date;

public class ProductSuppliersDto {
    
    private Long productId;
    private String supplierCode;
    private Date valueSuppliedToDate;
    private Long totalQuantitySuppliedToDate;
    private Date firstItemSuppliedDate;
    private Date lastItemSuppliedDate;
    private Long deliveryLeadTime;
    private Long standardPrice;
    private Long percentageDiscountMinimumOrderQuantity;
    private Long maximumOrderQuantity;
    private String otherItemSuppliersDetails;

    public ProductSuppliersDto(){

    }

    public ProductSuppliersDto(Long productId, String supplierCode, Date valueSuppliedToDate,
            Long totalQuantitySuppliedToDate, Date firstItemSuppliedDate, Date lastItemSuppliedDate,
            Long deliveryLeadTime, Long standardPrice, Long percentageDiscountMinimumOrderQuantity,
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
        this.percentageDiscountMinimumOrderQuantity = percentageDiscountMinimumOrderQuantity;
        this.maximumOrderQuantity = maximumOrderQuantity;
        this.otherItemSuppliersDetails = otherItemSuppliersDetails;
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
        return "ProductSuppliersDto [deliveryLeadTime=" + deliveryLeadTime + ", firstItemSuppliedDate="
                + firstItemSuppliedDate + ", lastItemSuppliedDate=" + lastItemSuppliedDate + ", maximumOrderQuantity="
                + maximumOrderQuantity + ", otherItemSuppliersDetails=" + otherItemSuppliersDetails
                + ", percentageDiscountMinimumOrderQuantity=" + percentageDiscountMinimumOrderQuantity + ", productId="
                + productId + ", standardPrice=" + standardPrice + ", supplierCode=" + supplierCode
                + ", totalQuantitySuppliedToDate=" + totalQuantitySuppliedToDate + ", valueSuppliedToDate="
                + valueSuppliedToDate + "]";
    }
}
