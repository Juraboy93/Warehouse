package com.example.warehouse.service;

import com.example.warehouse.dto.ApiResponse;
import com.example.warehouse.dto.MeasurementDto;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementService {
    final
    MeasurementRepository measurementRepository;

    public ApiResponse add(Measurement measurement) {
        Measurement save = measurementRepository.save(measurement);
        return new ApiResponse("Saved", true, save);
    }

    public ApiResponse edit(Long id, MeasurementDto measurementDto) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        Measurement measurement = optionalMeasurement.get();


        measurement.setName(measurementDto.getName());

        measurementRepository.save(measurement);
        return new ApiResponse("Updated!", true);
    }
}
