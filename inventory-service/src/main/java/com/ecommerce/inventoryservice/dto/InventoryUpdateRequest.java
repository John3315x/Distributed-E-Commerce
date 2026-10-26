package com.ecommerce.inventoryservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryUpdateRequest {

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @NotNull
    @Min(0)
    @Column(name = "reserved_quantity", nullable = false)
    private Integer reservedQuantity;
}
