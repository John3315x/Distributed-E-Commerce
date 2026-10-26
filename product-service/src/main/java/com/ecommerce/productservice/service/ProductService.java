package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.exception.DeleteProductException;
import com.ecommerce.productservice.exception.GetProductException;
import com.ecommerce.productservice.exception.UpdateProductException;
import com.ecommerce.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        // Implement product creation logic here
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setImage(productRequest.getImage());

        // Save the product to the database
        productRepository.save(product);
    }

    public void updateProduct(Long id, ProductRequest productRequest) {
        // Implement product update logic here
        Product product = productRepository.findById(id).orElseThrow(() -> new UpdateProductException("Product not found", HttpStatus.NOT_FOUND));

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setImage(productRequest.getImage());
        productRepository.save(product);

    }

    public Optional<ProductResponse> getProductById(Long id) {
        // Implement product retrieval logic here
        if (!productRepository.existsById(id)) {
            throw new GetProductException("Product not found", HttpStatus.NOT_FOUND);
        }

        // Convert Product entity to ProductResponse DTO
        return productRepository.findById(id).map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setImage(product.getImage());
            response.setActive(product.isActive());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        });
    }

    public List<ProductResponse> getAllProducts() {
        // Implement logic to retrieve all products here
        List<Product> products = productRepository.findAll();

        // Convert Product entities to ProductResponse DTOs
        return products.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setImage(product.getImage());
            response.setActive(product.isActive());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        }).toList();
    }

    public void deleteProduct(Long id) {
        // Implement product deletion logic here
        if (!productRepository.existsById(id)) {
            throw new DeleteProductException("Product not found", HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(id);
    }

    public List<ProductResponse> getProductsByCategory(String category) {

        if (!Category.exists(category)) {
            throw new GetProductException("Category not found", HttpStatus.NOT_FOUND);
        }

        Category categoryEnum = Category.valueOf(category);

        List<Product> products = productRepository.findByCategory(categoryEnum);

        return products.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setImage(product.getImage());
            response.setActive(product.isActive());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        }).toList();
    }

    public List<ProductResponse> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        
        // Validar datos de entrada
        if (minPrice == null || maxPrice == null) {
            throw new GetProductException("Price values cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {
            throw new GetProductException("Invalid price range", HttpStatus.BAD_REQUEST);
        }

        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);

        return products.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setImage(product.getImage());
            response.setActive(product.isActive());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        }).toList();
    }

    public List<ProductResponse> getProductsByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setImage(product.getImage());
            response.setActive(product.isActive());
            response.setCreatedAt(product.getCreatedAt());
            response.setUpdatedAt(product.getUpdatedAt());
            return response;
        }).toList();
    }
}
