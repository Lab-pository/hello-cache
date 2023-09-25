package com.example.hellocache.controller;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/v1/products")
    public ResponseEntity<ProductsResponse> getProductsWithPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        final ProductsResponse products = productService.getProductsWithPage(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v2/products")
    public ResponseEntity<ProductsResponse> getProductsWithSize(
            @RequestParam int page,
            @RequestParam int size
    ) {
        final ProductsResponse products = productService.getProductsWithSize(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/v3/products")
    public ResponseEntity<ProductsResponse> getProductsWithCursor(
            @RequestParam Long productId,
            @RequestParam int size
    ) {
        final ProductsResponse products = productService.getProductsWithCursor(productId, size);

        return ResponseEntity.ok(products);
    }
}
