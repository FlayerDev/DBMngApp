package com.FlayerDev.DBMngApp.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client extends Person {


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    public List<Document> getDocuments() { return documents; }

    public void setDocuments(List<Document> documents) { this.documents = documents; }
}
