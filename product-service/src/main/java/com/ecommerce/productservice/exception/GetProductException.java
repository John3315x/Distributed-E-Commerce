package com.ecommerce.productservice.exception;

import org.springframework.http.HttpStatus;

public class GetProductException extends RuntimeException {
    private final HttpStatus status;

    public GetProductException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
