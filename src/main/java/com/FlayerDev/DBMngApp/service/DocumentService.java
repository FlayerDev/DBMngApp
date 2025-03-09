package com.FlayerDev.DBMngApp.service;

import com.FlayerDev.DBMngApp.model.Document;
import com.FlayerDev.DBMngApp.model.Item;
import com.FlayerDev.DBMngApp.repository.IDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private IDocumentRepository documentRepository;

    @Autowired
    private ItemService itemService;

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document getDocumentById(UUID id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with id: " + id));
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document updateDocument(UUID id, Document updatedDocument) {
        Document document = getDocumentById(id);
        document.setName(updatedDocument.getName());
        if (updatedDocument.getPerson() != null) {
            document.setPerson(updatedDocument.getPerson());
        }
        if (updatedDocument.getItems() != null) {
            document.setItems(updatedDocument.getItems());
        }
        return documentRepository.save(document);
    }

    public void deleteDocument(UUID id) {
        Document document = getDocumentById(id);
        documentRepository.delete(document);
    }

    public Document addItemToDocument(UUID documentId, UUID itemId) {
        Document document = getDocumentById(documentId);
        Item item = itemService.getItemById(itemId);
        document.getItems().add(item);
        return documentRepository.save(document);
    }
}