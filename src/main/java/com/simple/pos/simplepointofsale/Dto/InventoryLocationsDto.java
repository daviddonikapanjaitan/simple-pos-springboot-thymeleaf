package com.simple.pos.simplepointofsale.Dto;

public class InventoryLocationsDto {

    private Long inventoryLocationId;
    private Long productId;
    private Long locationAddressId;
    private Long quantityInStock;
    private Long reoderLevel;
    private Long reorderQuantity;
    private Long totalAverageMonthlyUsage;
    private String otherInventoryDetails;

    public InventoryLocationsDto(){
        
    }

    public InventoryLocationsDto(Long productId, Long locationAddressId, Long quantityInStock,
            Long reoderLevel, Long reorderQuantity, Long totalAverageMonthlyUsage, String otherInventoryDetails) {
        super();
        this.productId = productId;
        this.locationAddressId = locationAddressId;
        this.quantityInStock = quantityInStock;
        this.reoderLevel = reoderLevel;
        this.reorderQuantity = reorderQuantity;
        this.totalAverageMonthlyUsage = totalAverageMonthlyUsage;
        this.otherInventoryDetails = otherInventoryDetails;
    }
    public Long getInventoryLocationId() {
        return inventoryLocationId;
    }
    public void setInventoryLocationId(Long inventoryLocationId) {
        this.inventoryLocationId = inventoryLocationId;
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
    public Long getReoderLevel() {
        return reoderLevel;
    }
    public void setReoderLevel(Long reoderLevel) {
        this.reoderLevel = reoderLevel;
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
        return "InventoryLocationsDto [inventoryLocationId=" + inventoryLocationId + ", locationAddressId="
                + locationAddressId + ", otherInventoryDetails=" + otherInventoryDetails + ", productId=" + productId
                + ", quantityInStock=" + quantityInStock + ", reoderLevel=" + reoderLevel + ", reorderQuantity="
                + reorderQuantity + ", totalAverageMonthlyUsage=" + totalAverageMonthlyUsage + "]";
    }
}
