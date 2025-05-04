package com.example.taxesapi.dto;

import java.util.List;

public record BillOutputDTO(List<Item> items, double totalTaxes, double total) {
    public record Item(String name, double priceTTC) {}
}
