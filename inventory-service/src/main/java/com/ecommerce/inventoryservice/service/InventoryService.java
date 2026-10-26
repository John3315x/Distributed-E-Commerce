package com.ecommerce.inventoryservice.service;

import com.ecommerce.inventoryservice.dto.InventoryCreateRequest;
import com.ecommerce.inventoryservice.dto.InventoryReservationRequest;
import com.ecommerce.inventoryservice.dto.InventoryResponse;
import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.exception.DeleteInventoryException;
import com.ecommerce.inventoryservice.exception.UpdateInventoryException;
import com.ecommerce.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void createInventory(InventoryCreateRequest inventoryCreateRequest) {
        // Implement inventory creation logic here
        Inventory inventory = new Inventory();
        inventory.setProductId(inventoryCreateRequest.getProductId());
        inventory.setQuantity(inventoryCreateRequest.getQuantity());
        inventory.setReservedQuantity(0); // Initialize reserved quantity to 0
        inventoryRepository.save(inventory);
    }

    public void updateReservedQuantity(Long inventoryId, InventoryReservationRequest inventoryReservationRequest) {
        // Implement reserved quantity update logic here
        Optional<Inventory> optionalInventory = inventoryRepository.findById(inventoryId);

        if (optionalInventory.isPresent()) {

            Inventory inventory = optionalInventory.get();
            int newReservedQuantity = inventory.getReservedQuantity() + inventoryReservationRequest.getQuantity();

            /**
             * Explicacion del condicional:
             * Verifica que la nueva cantidad reservada no sea negativa ni supere la cantidad disponible.
             */
            if (newReservedQuantity < 0 || newReservedQuantity > inventory.getQuantity()) {
                throw new UpdateInventoryException("Reserved quantity cannot be negative or exceed available quantity", HttpStatus.BAD_REQUEST);
            }

            inventory.setReservedQuantity(newReservedQuantity);
            inventoryRepository.save(inventory);

        } else {
            throw new IllegalArgumentException("Inventory not found");
        }

    }

    public Optional<InventoryResponse> getInventoryById(Long inventoryId) {
        // Implement inventory retrieval logic here
        return inventoryRepository.findById(inventoryId).map(inventory -> {
            InventoryResponse response = new InventoryResponse();
            response.setId(inventory.getId());
            response.setProductId(inventory.getProductId());
            response.setQuantity(inventory.getQuantity());
            return response;
        });
    }

    public List<InventoryResponse> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(inventory -> {
                    InventoryResponse response = new InventoryResponse();
                    response.setId(inventory.getId());
                    response.setProductId(inventory.getProductId());
                    response.setQuantity(inventory.getQuantity());
                    return response;
                })
                .collect(java.util.stream.Collectors.toList());
    }

    public void deleteInventory(Long inventoryId) {
        // Implement inventory deletion logic here
        if (!inventoryRepository.existsById(inventoryId)) {
            throw new DeleteInventoryException("Inventory not found", HttpStatus.NOT_FOUND);
        }
        inventoryRepository.deleteById(inventoryId);
    }

}
