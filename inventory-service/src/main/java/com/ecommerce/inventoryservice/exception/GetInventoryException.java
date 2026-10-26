package com.ecommerce.inventoryservice.exception;

import org.springframework.http.HttpStatus;

public class GetInventoryException extends RuntimeException {
    private final HttpStatus status;

    public GetInventoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
