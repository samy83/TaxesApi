package com.example.taxesapi.dto;

import com.example.taxesapi.model.Category;

public record ProductInputDTO(String name, double price, boolean imported, Category category) {}
