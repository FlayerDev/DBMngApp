package com.FlayerDev.DBMngApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JsonBackReference(value = "supplier-item")
    List<Supplier> suppliers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Supplier supplier) {

        this.suppliers = List.of(new Supplier[]{supplier});
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
