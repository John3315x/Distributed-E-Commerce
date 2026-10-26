package com.ecommerce.inventoryservice.exception;

import org.springframework.http.HttpStatus;

public class DeleteInventoryException extends RuntimeException {
    private final HttpStatus status;

    public DeleteInventoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
