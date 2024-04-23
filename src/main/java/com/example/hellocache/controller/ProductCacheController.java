package com.example.hellocache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.service.ProductCacheService;

@RestController
public class ProductCacheController {

    private final ProductCacheService productCacheService;

    public ProductCacheController(final ProductCacheService productCacheService) {
        this.productCacheService = productCacheService;
    }

    @GetMapping("/v1/products/cache")
    public ResponseEntity<ProductsResponse> getProductsWithPageAndCache(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final ProductsResponse products = productCacheService.getProductsWithPageAndRedisCache(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v2/products/cache")
    public ResponseEntity<ProductsResponse> getProductsWithCursorAndCache(
            @RequestParam(defaultValue = "0") final Long productId,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final ProductsResponse products = productCacheService.getProductsWithCursorAndRedisCache(productId, size);

        return ResponseEntity.ok(products);
    }
}
