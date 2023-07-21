package com.example.warehouse.repository;

import com.example.warehouse.entity.UserWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWarehouseRepository extends JpaRepository<UserWarehouse, Long> {
    List<UserWarehouse> findAllByUser_Id(Long user_id);
    List<UserWarehouse> findAllByUser_IdAndWarehouse_ActiveTrue(Long user_id);
}