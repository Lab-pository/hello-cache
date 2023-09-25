package com.example.hellocache.controller;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.service.ProductCacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCacheController {

    private final ProductCacheService productCacheService;

    public ProductCacheController(final ProductCacheService productCacheService) {
        this.productCacheService = productCacheService;
    }

    @GetMapping("/v1/products/cache")
    public ResponseEntity<ProductsResponse> getProductsWithPageAndCache(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        final ProductsResponse products = productCacheService.getProductsWithPageAndRedisCache(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v2/products/cache")
    public ResponseEntity<ProductsResponse> getProductsWithCursorAndCache(
            @RequestParam Long productId,
            @RequestParam int size
    ) {
        final ProductsResponse products = productCacheService.getProductsWithCursorAndRedisCache(productId, size);

        return ResponseEntity.ok(products);
    }
}
