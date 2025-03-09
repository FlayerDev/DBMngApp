package com.FlayerDev.DBMngApp.repository;

import com.FlayerDev.DBMngApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IClientRepository extends JpaRepository<Client, UUID> {
    Client findByName(String name);
}
