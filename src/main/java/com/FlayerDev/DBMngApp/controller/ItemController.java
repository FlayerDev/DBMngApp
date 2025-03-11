package com.FlayerDev.DBMngApp.controller;

import com.FlayerDev.DBMngApp.model.Item;
import com.FlayerDev.DBMngApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Add a new item
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(201).body(createdItem);
    }

    // Edit an existing item
    @PutMapping("/{id}")
    public ResponseEntity<Item> editItem(@PathVariable UUID id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        return ResponseEntity.ok(updatedItem);
    }

    // Add a supplier to an item
    @PostMapping("/{itemId}/suppliers/{supplierId}")
    public ResponseEntity<Item> addSupplierToItem(
            @PathVariable UUID itemId,
            @PathVariable UUID supplierId) {
        Item updatedItem = itemService.addSupplierToItem(itemId, supplierId);
        return ResponseEntity.ok(updatedItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
}