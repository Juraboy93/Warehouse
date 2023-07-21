package com.example.warehouse.repository;

import com.example.warehouse.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutputRepository extends JpaRepository<Output, Long> {
    List<Output> findByActiveTrue();
}