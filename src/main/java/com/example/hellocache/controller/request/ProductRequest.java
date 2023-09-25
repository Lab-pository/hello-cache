package com.example.hellocache.controller.request;

import com.example.hellocache.entity.Product;

public record ProductRequest(
        Long id,
        String name,
        String description,
        String price,
        Long quantity
) {

    public Product toEntity() {
        return new Product(id, name, description, price, quantity);
    }
}
