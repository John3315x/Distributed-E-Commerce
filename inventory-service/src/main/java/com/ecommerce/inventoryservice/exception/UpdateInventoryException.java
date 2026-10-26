package com.ecommerce.inventoryservice.exception;

import org.springframework.http.HttpStatus;

public class UpdateInventoryException extends RuntimeException {
    private final HttpStatus status;

    public UpdateInventoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
