package com.ecommerce.orderservice.dto;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.entity.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {

    private Long id;
    private Long userId;
    private OrderStatus status;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItemResponse> items;

    public OrderResponse() {
    }

    public OrderResponse(Long id, Long userId, OrderStatus status, BigDecimal total,
                         LocalDateTime createdAt, LocalDateTime updatedAt, List<OrderItemResponse> items) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.items = items;
    }

    public static OrderResponse fromEntity(Order order) {
        if (order == null) {
            return null;
        }

        List<OrderItemResponse> itemResponses = order.getItems() == null ? List.of()
                : order.getItems().stream()
                .map(OrderItemResponse::fromEntity)
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getStatus(),
                order.getTotal(),
                order.getCreatedAt(),
                order.getUpdatedAt(),
                itemResponses
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                ", total=" + total +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", items=" + items +
                '}';
    }
}
