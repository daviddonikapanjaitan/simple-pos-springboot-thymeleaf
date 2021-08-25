package com.simple.pos.simplepointofsale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory_Locations")
public class InventoryLocations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryLocationsId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "location_address_id")
    private Long locationAddressId;

    @Column(name = "quantity_in_stock")
    private Long quantityInStock;

    @Column(name = "reorder_level")
    private Long reorder_level;

    @Column(name = "reorded_quantity")
    private Long reorderQuantity;

    @Column(name = "totalAverageMonthlyUsaeg")
    private Long totalAverageMonthlyUsage;

    @Column(name = "other_inventory_details")
    private String otherInventoryDetails;

    public InventoryLocations(){
        
    }

    public InventoryLocations(Long inventoryLocationsId, Long productId, Long locationAddressId, Long quantityInStock,
        Long reorder_level, Long reorderQuantity, Long totalAverageMonthlyUsage, String otherInventoryDetails) {
        super();
        this.productId = productId;
        this.locationAddressId = locationAddressId;
        this.quantityInStock = quantityInStock;
        this.reorder_level = reorder_level;
        this.reorderQuantity = reorderQuantity;
        this.totalAverageMonthlyUsage = totalAverageMonthlyUsage;
        this.otherInventoryDetails = otherInventoryDetails;
    }

    public Long getInventoryLocationsId() {
        return inventoryLocationsId;
    }

    public void setInventoryLocationsId(Long inventoryLocationsId) {
        this.inventoryLocationsId = inventoryLocationsId;
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

    public Long getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(Long reorder_level) {
        this.reorder_level = reorder_level;
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
        return "InventoryLocations [inventoryLocationsId=" + inventoryLocationsId + ", locationAddressId="
                + locationAddressId + ", otherInventoryDetails=" + otherInventoryDetails + ", productId=" + productId
                + ", quantityInStock=" + quantityInStock + ", reorderQuantity=" + reorderQuantity + ", reorder_level="
                + reorder_level + ", totalAverageMonthlyUsage=" + totalAverageMonthlyUsage + "]";
    }
}
