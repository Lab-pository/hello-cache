package com.example.hellocache.service;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.entity.Product;
import com.example.hellocache.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ProductCacheService {

    private final ProductRepository productRepository;

    public ProductCacheService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Cacheable(value = "Products", key = "#page", cacheManager = "cacheManager")
    public ProductsResponse getProductsWithPageAndCache(final int page, final int size) {
        final Page<Product> products = productRepository.findAllWithPage(
            PageRequest.of(page, size));

        return ProductsResponse.from(products);
    }

    @Cacheable(value = "Products", key = "#productId", cacheManager = "cacheManager")
    public ProductsResponse getProductsWithCursorAndCache(final Long productId, final int size) {
        final Slice<Product> products = productRepository.findAllWithSliceByIdAfter(
            productId, PageRequest.of(0, size)
        );

        return ProductsResponse.from(products);
    }
}
