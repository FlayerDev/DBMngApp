package com.FlayerDev.DBMngApp.controller;

import com.FlayerDev.DBMngApp.model.Supplier;
import com.FlayerDev.DBMngApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Add a new supplier
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.status(201).body(createdSupplier);
    }

    // Edit an existing supplier
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable UUID id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    // Add a document to a supplier
    @PostMapping("/{supplierId}/documents/{documentId}")
    public ResponseEntity<Supplier> addDocumentToSupplier(
            @PathVariable UUID supplierId,
            @PathVariable UUID documentId) {
        Supplier updatedSupplier = supplierService.addDocumentToSupplier(supplierId, documentId);
        return ResponseEntity.ok(updatedSupplier);
    }

    // Add an item to a supplier
    @PostMapping("/{supplierId}/items/{itemId}")
    public ResponseEntity<Supplier> addItemToSupplier(
            @PathVariable UUID supplierId,
            @PathVariable UUID itemId) {
        Supplier updatedSupplier = supplierService.addItemToSupplier(supplierId, itemId);
        return ResponseEntity.ok(updatedSupplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }
}