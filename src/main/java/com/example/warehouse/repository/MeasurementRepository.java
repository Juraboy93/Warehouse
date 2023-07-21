package com.example.warehouse.repository;

import com.example.warehouse.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findAllByActiveTrue();
}