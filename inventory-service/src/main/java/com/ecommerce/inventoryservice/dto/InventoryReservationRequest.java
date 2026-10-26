package com.ecommerce.inventoryservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryReservationRequest {

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity cannot be less than 1")
    private Integer quantity;

    public InventoryReservationRequest() {
    }

    public InventoryReservationRequest(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
