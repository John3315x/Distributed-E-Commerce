package com.ecommerce.orderservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class OrderCreateRequest {


    @NotNull(message = "Order items are required")
    @Valid
    private List<OrderItemRequest> items;

    public OrderCreateRequest() {
    }

    public OrderCreateRequest(List<OrderItemRequest> items) {
        this.items = items;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderCreateRequest{" +
                "items=" + items +
                '}';
    }
}
