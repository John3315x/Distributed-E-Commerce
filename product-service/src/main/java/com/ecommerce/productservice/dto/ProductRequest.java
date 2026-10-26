package com.ecommerce.productservice.dto;

import com.ecommerce.productservice.entity.Category;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 150, message = "The product name must be between 3 and 150 characters.")
    @Pattern(regexp = "^[\\p{L}\\p{N} .,_#\\-/()]+$", message = "The product name contains invalid characters.")
    private String name;

    @Size(max = 2000, message = "The description cannot exceed 2000 characters.")
    @Pattern(regexp = "^[\\p{L}\\p{N} \\r\\n\\t.,;:_#@/\\-()\\[\\]\\{\\}+=*\\$%&!?\\\"'<>]+$", message = "The description contains invalid characters.")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0.")
    @Digits(integer = 10, fraction = 2, message = "Price must have a maximum of 2 decimal places.")
    private BigDecimal price;

    @NotNull(message = "Category is required")
    private Category category;

    @Size(max = 500, message = "The image URL cannot exceed 500 characters.")
    @Pattern(regexp = "^(https?://.*|/.*)?$", message = "The image must be a valid URL or path.")
    private String image;

    public ProductRequest() {
    }

    public ProductRequest(String name, String description, BigDecimal price, Category category, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", image='" + image + '\'' +
                '}';
    }
}
