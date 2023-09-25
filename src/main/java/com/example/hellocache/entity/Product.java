package com.example.hellocache.entity;

import com.example.hellocache.controller.request.ProductRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description", columnDefinition = "longtext", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP(6)", nullable = false)
    private Instant startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP(6)", nullable = false)
    private Instant endTime;

    protected Product() {
    }

    public Product(
            final Long id,
            final String name,
            final String description,
            final String price,
            final Long quantity
    ) {
        this(id, name, description, price, quantity, Instant.now(), Instant.now());
    }

    public Product(
            final Long id,
            final String name,
            final String description,
            final String price,
            final Long quantity,
            final Instant startTime,
            final Instant endTime
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void update(final ProductRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.quantity = request.quantity();
        this.updatedAt = Instant.now();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrice() {
        return this.price;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public Instant getStartTime() {
        return this.startTime;
    }

    public Instant getEndTime() {
        return this.endTime;
    }

}
