package com.example.warehouse.service;

import com.example.warehouse.dto.ApiResponse;
import com.example.warehouse.dto.CurrencyDto;
import com.example.warehouse.entity.Currency;
import com.example.warehouse.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    final CurrencyRepository currencyRepository;

    public ApiResponse add(Currency currency) {
        Currency save = currencyRepository.save(currency);
        return new ApiResponse("Saved", true, save);
    }
    public ApiResponse edit(Long id, CurrencyDto currencyDto) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        Currency currency = optionalCurrency.get();


        currency.setName(currencyDto.getName());

        currencyRepository.save(currency);
        return new ApiResponse("Updated!", true);
    }
}
