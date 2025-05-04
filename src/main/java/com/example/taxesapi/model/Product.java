package com.example.taxesapi.model;

import java.util.EnumSet;

public class Product {
    private String name;
    private double price;
    private boolean imported;
    private Category category;

    public Product(String name, double price, boolean imported, Category category) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isImported() { return imported; }
    public Category getCategory() { return category; }

    public boolean isExempt() {
        return EnumSet.of(Category.BOOK, Category.FOOD, Category.MEDICAL).contains(category);
    }
}
