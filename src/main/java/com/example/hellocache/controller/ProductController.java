package com.example.hellocache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.service.ProductService;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/v1/products")
    public ResponseEntity<ProductsResponse> getProductsWithPage(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final ProductsResponse products = productService.getProductsWithPage(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v2/products")
    public ResponseEntity<ProductsResponse> getProductsWithSize(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final ProductsResponse products = productService.getProductsWithSize(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v3/products")
    public ResponseEntity<ProductsResponse> getProductsWithCursor(
            @RequestParam(defaultValue = "0") final Long productId,
            @RequestParam(defaultValue = "10") final int size
    ) {
        final ProductsResponse products = productService.getProductsWithCursor(productId, size);

        return ResponseEntity.ok(products);
    }
}
