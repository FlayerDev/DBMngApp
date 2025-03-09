package com.FlayerDev.DBMngApp.repository;

import com.FlayerDev.DBMngApp.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ISupplierRepository extends JpaRepository<Supplier, UUID> {
    Supplier findByName(String name);
}
