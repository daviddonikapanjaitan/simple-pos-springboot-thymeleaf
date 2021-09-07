package com.simple.pos.simplepointofsale.Dto;

public class ProductSuppliersDto {
    
    private String productId;
    private String supplierCode;
    private String valueSuppliedToDate;
    private String totalQuantitySuppliedToDate;
    private String firstItemSuppliedDate;
    private String lastItemSuppliedDate;
    private String deliveryLeadTime;
    private String standardPrice;
    private String percentageDiscount;
    private String MinimumOrderQuantity;
    private String maximumOrderQuantity;
    private String otherItemSuppliersDetails;

    public ProductSuppliersDto(){

    }

    public ProductSuppliersDto(String productId, String supplierCode, String valueSuppliedToDate,
            String totalQuantitySuppliedToDate, String firstItemSuppliedDate, String lastItemSuppliedDate,
            String deliveryLeadTime, String standardPrice, String percentageDiscount, String minimumOrderQuantity,
            String maximumOrderQuantity, String otherItemSuppliersDetails) {
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getValueSuppliedToDate() {
        return valueSuppliedToDate;
    }

    public void setValueSuppliedToDate(String valueSuppliedToDate) {
        this.valueSuppliedToDate = valueSuppliedToDate;
    }

    public String getTotalQuantitySuppliedToDate() {
        return totalQuantitySuppliedToDate;
    }

    public void setTotalQuantitySuppliedToDate(String totalQuantitySuppliedToDate) {
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

    public String getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public String getMinimumOrderQuantity() {
        return MinimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(String minimumOrderQuantity) {
        MinimumOrderQuantity = minimumOrderQuantity;
    }

    public String getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(String maximumOrderQuantity) {
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
