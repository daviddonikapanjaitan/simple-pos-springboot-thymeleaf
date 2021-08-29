package com.simple.pos.simplepointofsale.Dto;

public class InventoryLocationsDto {

    private Long productId;
    private Long locationAddressId;
    private Long quantityInStock;
    private Long reorderLevel;
    private Long reorderQuantity;
    private Long totalAverageMonthlyUsage;
    private String otherInventoryDetails;

    public InventoryLocationsDto(){
        
    }

    public InventoryLocationsDto(Long productId, Long locationAddressId, Long quantityInStock, Long reorderLevel,
            Long reorderQuantity, Long totalAverageMonthlyUsage, String otherInventoryDetails) {
        super();
        this.productId = productId;
        this.locationAddressId = locationAddressId;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
        this.reorderQuantity = reorderQuantity;
        this.totalAverageMonthlyUsage = totalAverageMonthlyUsage;
        this.otherInventoryDetails = otherInventoryDetails;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getLocationAddressId() {
        return locationAddressId;
    }

    public void setLocationAddressId(Long locationAddressId) {
        this.locationAddressId = locationAddressId;
    }

    public Long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Long getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Long reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Long getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(Long reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public Long getTotalAverageMonthlyUsage() {
        return totalAverageMonthlyUsage;
    }

    public void setTotalAverageMonthlyUsage(Long totalAverageMonthlyUsage) {
        this.totalAverageMonthlyUsage = totalAverageMonthlyUsage;
    }

    public String getOtherInventoryDetails() {
        return otherInventoryDetails;
    }

    public void setOtherInventoryDetails(String otherInventoryDetails) {
        this.otherInventoryDetails = otherInventoryDetails;
    }

    @Override
    public String toString() {
        return "InventoryLocationsDto [locationAddressId=" + locationAddressId + ", otherInventoryDetails="
                + otherInventoryDetails + ", productId=" + productId + ", quantityInStock=" + quantityInStock
                + ", reorderLevel=" + reorderLevel + ", reorderQuantity=" + reorderQuantity
                + ", totalAverageMonthlyUsage=" + totalAverageMonthlyUsage + "]";
    }
}
