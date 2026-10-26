package com.ecommerce.inventoryservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Representa el stock del producto en el servicio de inventario.
 *
 * Los limites y validaciones de negocio se definen en la base de datos
 * mediante los CHECKs y UNIQUE establecidos en la tabla inventory.
 */
@Entity
@Table(
    name = "inventory",
    uniqueConstraints = {
        @UniqueConstraint(name = "inventory_product_unique", columnNames = "product_id")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_id", nullable = false, unique = true)
    private Long productId;

    @NotNull
    @Min(0)
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Min(0)
    @Column(name = "reserved_quantity", nullable = false)
    private Integer reservedQuantity;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
