package com.example.hellocache.repository;

import com.example.hellocache.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    Page<Product> findAllWithPage(final Pageable pageable);

    @Query("select p from Product p")
    Slice<Product> findAllWithSlice(final Pageable pageable);

    Slice<Product> findAllWithSliceByIdAfter(final Long productId, final Pageable pageable);
}
