package com.FlayerDev.DBMngApp.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Document> getDocuments() { return documents; }

    public void setDocuments(List<Document> documents) { this.documents = documents; }
}
