package com.FlayerDev.DBMngApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Supplier extends Person {

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "person-document")
    private List<Document> documents;

    @ManyToMany
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Document> getDocuments() { return documents; }

    public void setDocuments(List<Document> documents) { this.documents = documents; }
}