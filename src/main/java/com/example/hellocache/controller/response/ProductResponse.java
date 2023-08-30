package com.example.hellocache.controller.response;

import com.example.hellocache.entity.Product;

public record ProductResponse(
    Long productId,
    String name,
    String price,
    String startTime,
    String endTime
) {

    public static ProductResponse from(final Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStartTime().toString(),
            product.getEndTime().toString()
        );
    }
}
