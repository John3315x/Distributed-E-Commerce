package com.ecommerce.inventoryservice.dto;

import com.ecommerce.inventoryservice.entity.Inventory;
import java.time.LocalDateTime;

public class InventoryResponse {

    private Long id;
    private Long productId;
    private Integer quantity;
    private Integer reservedQuantity;
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InventoryResponse() {
    }

    /**
     * Constructor completo para inicializar todos los campos de la respuesta de inventario.
     * @param id
     * @param productId
     * @param quantity
     * @param reservedQuantity
     * @param version
     * @param createdAt
     * @param updatedAt
     */
    public InventoryResponse(Long id, Long productId, Integer quantity, Integer reservedQuantity,
                             Long version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.reservedQuantity = reservedQuantity;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Convierte una entidad Inventory a un DTO InventoryResponse.
     * @param inventory La entidad Inventory a convertir.
     * @return Un objeto InventoryResponse que representa la entidad proporcionada.
     */
    public static InventoryResponse fromEntity(Inventory inventory) {
        if (inventory == null) {
            return null;
        }

        return new InventoryResponse(
                inventory.getId(),
                inventory.getProductId(),
                inventory.getQuantity(),
                inventory.getReservedQuantity(),
                inventory.getVersion(),
                inventory.getCreatedAt(),
                inventory.getUpdatedAt()
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

    public Integer getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(Integer reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", reservedQuantity=" + reservedQuantity +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
