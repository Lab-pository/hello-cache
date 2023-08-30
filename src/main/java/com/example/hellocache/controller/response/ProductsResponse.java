package com.example.hellocache.controller.response;

import com.example.hellocache.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

public record ProductsResponse(
    List<ProductResponse> products,
    int page,
    int totalPage,
    boolean hasNext
) {

    private static final int UNKNOWN_TOTAL_PAGE = -1;

    public static ProductsResponse from(final Page<Product> products) {
        return new ProductsResponse(
            products.get().map(ProductResponse::from).toList(),
            products.getNumber(),
            products.getTotalPages(),
            products.hasNext()
        );
    }

    public static ProductsResponse from(final Slice<Product> products) {
        return new ProductsResponse(
            products.get().map(ProductResponse::from).toList(),
            products.getNumber(),
            UNKNOWN_TOTAL_PAGE,
            products.hasNext()
        );
    }
}
