package com.example.taxesapi.dto;

import com.example.taxesapi.entity.Category;

public record ProductInputDTO(String name, double price, boolean imported, Category category) {}
