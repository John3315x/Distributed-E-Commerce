package com.ecommerce.inventoryservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CreateInventoryException.class)
    public ResponseEntity<?> handleCreateInventory(CreateInventoryException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "INVENTORY_CREATION_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }

    @ExceptionHandler(UpdateInventoryException.class)
    public ResponseEntity<?> handleUpdateInventory(UpdateInventoryException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "INVENTORY_UPDATE_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);// El status se obtiene del propio exception
    }

    @ExceptionHandler(GetInventoryException.class)
    public ResponseEntity<?> handleGetInventory(GetInventoryException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "GETTING_INVENTORY_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }

    @ExceptionHandler(DeleteInventoryException.class)
    public ResponseEntity<?> handleDeleteInventory(DeleteInventoryException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "INVENTORY_DELETION_FAILED");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(ex.getStatus()).body(body);
    }
}
