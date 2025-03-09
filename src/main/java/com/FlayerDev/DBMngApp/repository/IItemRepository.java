package com.FlayerDev.DBMngApp.repository;

import com.FlayerDev.DBMngApp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IItemRepository extends JpaRepository<Item, UUID> {
    Item findByName(String name);
}
