package com.ecommerce.productservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CreateProductException.class)
    public ResponseEntity<?> handleCreateProduct(CreateProductException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "PRODUCT_CREATION_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }

    @ExceptionHandler(UpdateProductException.class)
    public ResponseEntity<?> handleUpdateProduct(UpdateProductException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "PRODUCT_UPDATE_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);// El status se obtiene del propio exception
    }

    @ExceptionHandler(GetProductException.class)
    public ResponseEntity<?> handleGetProduct(GetProductException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "GETTING_PRODUCT_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }

    @ExceptionHandler(DeleteProductException.class)
    public ResponseEntity<?> handleDeleteProduct(DeleteProductException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "PRODUCT_DELETION_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }
}
