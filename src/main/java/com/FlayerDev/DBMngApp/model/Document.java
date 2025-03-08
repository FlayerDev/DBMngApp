package com.FlayerDev.DBMngApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Document {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference(value = "document-item")
    private List<Item> items;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {return client;}

    public void setClient(Client client) {this.client = client;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
