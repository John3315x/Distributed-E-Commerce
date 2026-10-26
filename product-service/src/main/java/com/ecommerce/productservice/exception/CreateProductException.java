package com.ecommerce.productservice.exception;

import org.springframework.http.HttpStatus;

public class CreateProductException extends RuntimeException {
    private final HttpStatus status;

    public CreateProductException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
