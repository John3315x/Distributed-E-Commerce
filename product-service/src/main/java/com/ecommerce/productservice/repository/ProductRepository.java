package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findByCategory(Category categoryEnum);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findByName(String name);
}
