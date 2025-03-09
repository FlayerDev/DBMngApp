package com.FlayerDev.DBMngApp.service;

import com.FlayerDev.DBMngApp.model.Document;
import com.FlayerDev.DBMngApp.model.Item;
import com.FlayerDev.DBMngApp.model.Supplier;
import com.FlayerDev.DBMngApp.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ItemService itemService;

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplierById(UUID id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier updateSupplier(UUID id, Supplier updatedSupplier) {
        Supplier supplier = getSupplierById(id);
        supplier.setName(updatedSupplier.getName());
        if (updatedSupplier.getDocuments() != null) {
            supplier.setDocuments(updatedSupplier.getDocuments());
        }
        if (updatedSupplier.getItems() != null) {
            supplier.setItems(updatedSupplier.getItems());
        }
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(UUID id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
    }

    public Supplier addDocumentToSupplier(UUID supplierId, UUID documentId) {
        Supplier supplier = getSupplierById(supplierId);
        Document document = documentService.getDocumentById(documentId);
        document.setPerson(supplier);
        supplier.getDocuments().add(document);
        return supplierRepository.save(supplier);
    }

    public Supplier addItemToSupplier(UUID supplierId, UUID itemId) {
        Supplier supplier = getSupplierById(supplierId);
        Item item = itemService.getItemById(itemId);
        supplier.getItems().add(item);
        item.getSuppliers().add(supplier); // Maintain bidirectional relationship
        return supplierRepository.save(supplier);
    }
}