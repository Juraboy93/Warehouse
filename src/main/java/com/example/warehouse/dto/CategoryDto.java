package com.example.warehouse.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private String name;
    private String parentCategoryId;
}
