package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CRUD operations
    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody @Valid ProductRequest productRequest) {
        // Implement product creation logic here
        productService.createProduct(productRequest);
        return ResponseEntity.status(201).body("Product created successfully");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest productRequest) {
        // Implement product update logic here
        productService.updateProduct(id, productRequest);
        return ResponseEntity.status(201).body("Product updated successfully");
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        // Implement product retrieval logic here
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllProducts")
    public List<ProductResponse> getAllProducts() {
        // Implement logic to retrieve all products here
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        // Implement product deletion logic here
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("Product deleted successfully");
    }

    // Additional endpoints for filtering products
    @GetMapping("/getProductsByCategory/{category}")
    public List<ProductResponse> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/getProductsByName")
    public List<ProductResponse> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/getProductsByPriceRange")
    public List<ProductResponse> getProductsByPriceRange(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

}
