package com.example.warehouse.repository;

import com.example.warehouse.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findAllByActiveTrue();
}