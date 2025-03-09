package com.FlayerDev.DBMngApp.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client extends Person {


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "person-document")
    private List<Document> documents;

    public List<Document> getDocuments() { return documents; }

    public void setDocuments(List<Document> documents) { this.documents = documents; }
}
