package com.FlayerDev.DBMngApp.service;

import com.FlayerDev.DBMngApp.model.Item;
import com.FlayerDev.DBMngApp.model.Supplier;
import com.FlayerDev.DBMngApp.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private IItemRepository itemRepository;

    @Autowired
    private SupplierService supplierService;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(UUID id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(UUID id, Item updatedItem) {
        Item item = getItemById(id);
        item.setName(updatedItem.getName());
        if (updatedItem.getSuppliers() != null) {
            item.setSuppliers(updatedItem.getSuppliers());
        }
        return itemRepository.save(item);
    }

    public void deleteItem(UUID id) {
        Item item = getItemById(id);
        itemRepository.delete(item);
    }

    public Item addSupplierToItem(UUID itemId, UUID supplierId) {
        Item item = getItemById(itemId);
        Supplier supplier = supplierService.getSupplierById(supplierId);
        item.getSuppliers().add(supplier);
        supplier.getItems().add(item); // Maintain bidirectional relationship
        return itemRepository.save(item);
    }
}