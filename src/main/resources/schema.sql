DROP TABLE if exists product cascade;
CREATE TABLE product
(
    product_id  bigint       not null,
    quantity    bigint       not null,
    start_time  TIMESTAMP(6) not null,
    end_time    TIMESTAMP(6) not null,
    created_at  TIMESTAMP(6) not null,
    updated_at  TIMESTAMP(6) not null,
    name        varchar(255) not null,
    price       varchar(255) not null,
    description longtext     not null,
    primary key (product_id)
);
