package com.ecommerce.inventoryservice.exception;

import org.springframework.http.HttpStatus;

public class CreateInventoryException extends RuntimeException {
    private final HttpStatus status;

    public CreateInventoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
