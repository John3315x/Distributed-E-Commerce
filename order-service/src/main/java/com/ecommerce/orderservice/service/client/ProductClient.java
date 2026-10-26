package com.ecommerce.orderservice.service.client;

import com.ecommerce.orderservice.dto.product.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "product-service",
        url = "${services.product.url}"
)
public interface ProductClient {

    @GetMapping("/products/getAllProducts")
    List<ProductResponse> getAllProducts();
}
