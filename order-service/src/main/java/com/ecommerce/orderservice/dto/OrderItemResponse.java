package com.ecommerce.orderservice.dto;

import com.ecommerce.orderservice.entity.OrderItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemResponse {

    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
    private LocalDateTime createdAt;

    public OrderItemResponse() {
    }

    public OrderItemResponse(Long id, Long productId, Integer quantity, BigDecimal unitPrice,
                            BigDecimal subtotal, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
        this.createdAt = createdAt;
    }

    public static OrderItemResponse fromEntity(OrderItem item) {
        if (item == null) {
            return null;
        }

        return new OrderItemResponse(
                item.getId(),
                item.getProductId(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getSubtotal(),
                item.getCreatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderItemResponse{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                ", createdAt=" + createdAt +
                '}';
    }
}
