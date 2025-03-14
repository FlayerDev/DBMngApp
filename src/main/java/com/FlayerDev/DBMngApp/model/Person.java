package com.FlayerDev.DBMngApp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
