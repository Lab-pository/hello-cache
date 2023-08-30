package com.example.hellocache.service;

import com.example.hellocache.controller.response.ProductsResponse;
import com.example.hellocache.entity.Product;
import com.example.hellocache.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductsResponse getProductsWithPage(final int page, final int size) {
        final Page<Product> products = productRepository.findAllWithPage(
            PageRequest.of(page, size));

        return ProductsResponse.from(products);
    }

    public ProductsResponse getProductsWithSize(final int page, final int size) {
        final Slice<Product> products = productRepository.findAllWithSlice(
            PageRequest.of(page, size));

        return ProductsResponse.from(products);
    }

    public ProductsResponse getProductsWithCursor(final Long productId, final int size) {
        final Slice<Product> products = productRepository.findAllWithSliceByIdAfter(
            productId, PageRequest.of(0, size)
        );

        return ProductsResponse.from(products);
    }
}
