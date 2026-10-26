package com.ecommerce.inventoryservice.controller;

import com.ecommerce.inventoryservice.dto.InventoryCreateRequest;
import com.ecommerce.inventoryservice.dto.InventoryReservationRequest;
import com.ecommerce.inventoryservice.dto.InventoryResponse;
import com.ecommerce.inventoryservice.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/createInventory")
    public ResponseEntity createInventory(@RequestBody @Valid InventoryCreateRequest inventoryCreateRequest) {
        // Implement inventory creation logic here
        inventoryService.createInventory(inventoryCreateRequest);
        return ResponseEntity.status(201).body("Inventory created successfully");
    }

    @PostMapping("/updateReservedQuantity")
    public ResponseEntity updateReservedQuantity(@RequestBody Long inventoryId, @RequestBody @Valid InventoryReservationRequest inventoryReservationRequest) {
        // Implement reserved quantity update logic here
        inventoryService.updateReservedQuantity(inventoryId, inventoryReservationRequest);
        return ResponseEntity.status(200).body("Reserved quantity updated successfully");
    }

    @GetMapping("/getInventoryById/{inventoryId}")
    public ResponseEntity<InventoryResponse> getInventoryById(@PathVariable Long inventoryId) {
        // Implement inventory retrieval logic here
        return inventoryService.getInventoryById(inventoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllInventories")
    public List<InventoryResponse> getAllInventories() {
        // Implement logic to retrieve all inventories here
        return inventoryService.getAllInventories();
    }

    @DeleteMapping("/deleteInventory/{inventoryId}")
    public ResponseEntity deleteInventory(@PathVariable Long inventoryId) {
        // Implement inventory deletion logic here
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.status(200).body("Inventory deleted successfully");
    }

}
