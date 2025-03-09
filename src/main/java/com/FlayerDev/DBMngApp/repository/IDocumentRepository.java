package com.FlayerDev.DBMngApp.repository;

import com.FlayerDev.DBMngApp.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IDocumentRepository extends JpaRepository<Document, UUID> {
    Document findByName(String name);
}
