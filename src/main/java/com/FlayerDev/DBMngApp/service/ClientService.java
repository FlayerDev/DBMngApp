package com.FlayerDev.DBMngApp.service;

import com.FlayerDev.DBMngApp.model.Client;
import com.FlayerDev.DBMngApp.model.Document;
import com.FlayerDev.DBMngApp.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private DocumentService documentService; // For managing related documents

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(UUID id, Client updatedClient) {
        Client client = getClientById(id);
        client.setName(updatedClient.getName());
        // Update documents if provided
        if (updatedClient.getDocuments() != null) {
            client.setDocuments(updatedClient.getDocuments());
        }
        return clientRepository.save(client);
    }

    public void deleteClient(UUID id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }

    public Client addDocumentToClient(UUID clientId, UUID documentId) {
        Client client = getClientById(clientId);
        Document document = documentService.getDocumentById(documentId);
        document.setPerson(client); // Set the relationship
        client.getDocuments().add(document);
        return clientRepository.save(client);
    }
}