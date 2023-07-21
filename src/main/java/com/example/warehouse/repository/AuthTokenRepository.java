package com.example.warehouse.repository;

import com.example.warehouse.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthTokenRepository extends JpaRepository<AuthToken, UUID> {
}