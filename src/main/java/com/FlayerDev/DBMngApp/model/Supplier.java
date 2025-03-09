package com.FlayerDev.DBMngApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Supplier extends Person {

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "supplier-item")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}