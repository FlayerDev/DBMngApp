package com.FlayerDev.DBMngApp.controller;

import com.FlayerDev.DBMngApp.model.Client;
import com.FlayerDev.DBMngApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Add a new client
    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    // Edit an existing client
    @PutMapping("/{id}")
    public ResponseEntity<Client> editClient(@PathVariable UUID id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    // Add a document to a client
    @PostMapping("/{clientId}/documents/{documentId}")
    public ResponseEntity<Client> addDocumentToClient(
            @PathVariable UUID clientId,
            @PathVariable UUID documentId) {
        Client updatedClient = clientService.addDocumentToClient(clientId, documentId);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }
}