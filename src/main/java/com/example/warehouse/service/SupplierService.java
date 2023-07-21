package com.example.warehouse.service;

import com.example.warehouse.dto.ApiResponse;
import com.example.warehouse.dto.SupplierDto;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    final SupplierRepository supplierRepository;

    public void add(SupplierDto supplierDto){
        Supplier supplier=new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplierRepository.save(supplier);
    }

    public ApiResponse edit(SupplierDto supplierDto, Long id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        Supplier supplier = byId.get();
        supplier.setName(supplierDto.getName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplierRepository.save(supplier);
        return null;
    }

    public void delete(Long id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        byId.get().setActive(false);
        supplierRepository.save(byId.get());
    }

}
