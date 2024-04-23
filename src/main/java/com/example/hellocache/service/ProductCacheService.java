package com.example.hellocache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.entity.Product;
import com.example.hellocache.repository.ProductRepository;

@Service
@Transactional(readOnly = true)
public class ProductCacheService {

    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public ProductCacheService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products.page", key = "#page", cacheManager = "redisCacheManager")
    public ProductsResponse getProductsWithPageAndRedisCache(final int page, final int size) {
        log.info("ProductCacheService.getProductsWithPageAndRedisCache");
        final Page<Product> products = productRepository.findAllWithPage(PageRequest.of(page, size));

        return ProductsResponse.from(products);
    }

    @Cacheable(value = "products.cursor", key = "#productId", cacheManager = "redisCacheManager")
    public ProductsResponse getProductsWithCursorAndRedisCache(final Long productId, final int size) {
        log.info("ProductCacheService.getProductsWithCursorAndRedisCache");
        final Slice<Product> products = productRepository.findAllWithSliceByIdAfter(productId, PageRequest.of(0, size));

        return ProductsResponse.from(products);
    }
}
