package com.FlayerDev.DBMngApp.controller;

import com.FlayerDev.DBMngApp.model.Document;
import com.FlayerDev.DBMngApp.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Add a new document
    @PostMapping("/clients/{clientId}")
    public ResponseEntity<Document> addDocumentForClient(
            @PathVariable UUID clientId,
            @RequestBody Document document) {
        // Note: The client must be set in the service layer or client-side
        Document createdDocument = documentService.createDocument(document);
        return ResponseEntity.status(201).body(createdDocument);
    }

    // Add a new document for a supplier
    @PostMapping("/suppliers/{supplierId}")
    public ResponseEntity<Document> addDocumentForSupplier(
            @PathVariable UUID supplierId,
            @RequestBody Document document) {
        // Note: The supplier must be set in the service layer or client-side
        Document createdDocument = documentService.createDocument(document);
        return ResponseEntity.status(201).body(createdDocument);
    }

    // Edit an existing document
    @PutMapping("/{id}")
    public ResponseEntity<Document> editDocument(
            @PathVariable UUID id,
            @RequestBody Document document) {
        Document updatedDocument = documentService.updateDocument(id, document);
        return ResponseEntity.ok(updatedDocument);
    }

    // Add an item to a document
    @PostMapping("/{documentId}/items/{itemId}")
    public ResponseEntity<Document> addItemToDocument(
            @PathVariable UUID documentId,
            @PathVariable UUID itemId) {
        Document updatedDocument = documentService.addItemToDocument(documentId, itemId);
        return ResponseEntity.ok(updatedDocument);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }
}