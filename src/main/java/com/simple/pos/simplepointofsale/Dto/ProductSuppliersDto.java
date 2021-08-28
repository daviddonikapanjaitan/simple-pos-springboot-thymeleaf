package com.simple.pos.simplepointofsale.Dto;

public class ProductSuppliersDto {
    
    private Long productId;
    private String supplierCode;
    private Long valueSuppliedToDate;
    private Long totalQuantitySuppliedToDate;
    private String firstItemSuppliedDate;
    private String lastItemSuppliedDate;
    private String deliveryLeadTime;
    private Long standardPrice;
    private Long percentageDiscount;
    private Long MinimumOrderQuantity;
    private Long maximumOrderQuantity;
    private String otherItemSuppliersDetails;

    public ProductSuppliersDto(){

    }

    public ProductSuppliersDto(Long productId, String supplierCode, Long valueSuppliedToDate,
            Long totalQuantitySuppliedToDate, String firstItemSuppliedDate, String lastItemSuppliedDate,
            String deliveryLeadTime, Long standardPrice, Long percentageDiscount, Long minimumOrderQuantity,
            Long maximumOrderQuantity, String otherItemSuppliersDetails) {
        this.productId = productId;
        this.supplierCode = supplierCode;
        this.valueSuppliedToDate = valueSuppliedToDate;
        this.totalQuantitySuppliedToDate = totalQuantitySuppliedToDate;
        this.firstItemSuppliedDate = firstItemSuppliedDate;
        this.lastItemSuppliedDate = lastItemSuppliedDate;
        this.deliveryLeadTime = deliveryLeadTime;
        this.standardPrice = standardPrice;
        this.percentageDiscount = percentageDiscount;
        MinimumOrderQuantity = minimumOrderQuantity;
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

    public String getFirstItemSuppliedDate() {
        return firstItemSuppliedDate;
    }

    public void setFirstItemSuppliedDate(String firstItemSuppliedDate) {
        this.firstItemSuppliedDate = firstItemSuppliedDate;
    }

    public String getLastItemSuppliedDate() {
        return lastItemSuppliedDate;
    }

    public void setLastItemSuppliedDate(String lastItemSuppliedDate) {
        this.lastItemSuppliedDate = lastItemSuppliedDate;
    }

    public String getDeliveryLeadTime() {
        return deliveryLeadTime;
    }

    public void setDeliveryLeadTime(String deliveryLeadTime) {
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
        return MinimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(Long minimumOrderQuantity) {
        MinimumOrderQuantity = minimumOrderQuantity;
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
        return "ProductSuppliersDto [MinimumOrderQuantity=" + MinimumOrderQuantity + ", deliveryLeadTime="
                + deliveryLeadTime + ", firstItemSuppliedDate=" + firstItemSuppliedDate + ", lastItemSuppliedDate="
                + lastItemSuppliedDate + ", maximumOrderQuantity=" + maximumOrderQuantity
                + ", otherItemSuppliersDetails=" + otherItemSuppliersDetails + ", percentageDiscount="
                + percentageDiscount + ", productId=" + productId + ", standardPrice=" + standardPrice
                + ", supplierCode=" + supplierCode + ", totalQuantitySuppliedToDate=" + totalQuantitySuppliedToDate
                + ", valueSuppliedToDate=" + valueSuppliedToDate + "]";
    }
}
