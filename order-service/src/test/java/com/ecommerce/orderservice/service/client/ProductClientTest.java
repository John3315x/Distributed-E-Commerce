package com.ecommerce.orderservice.service.client;

import com.ecommerce.orderservice.dto.product.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductClientTest {

    @Autowired
    private ProductClient productClient;

    @Test
    void shouldGetAllProducts() {
        List<ProductResponse> products = productClient.getAllProducts();
        System.out.println(products);
    }

}
