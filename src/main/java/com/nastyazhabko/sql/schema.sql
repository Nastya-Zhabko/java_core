--создание таблицы orders
CREATE TABLE orders
(
    order_id    SERIAL PRIMARY KEY,
    customer_id INT       NOT NULL,
    product_id  INT       NOT NULL,
    created_at  TIMESTAMP NOT NULL,
    amount      NUMERIC(10, 2),
    status      TEXT
);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customer
        FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
    ADD CONSTRAINT fk_orders_product
        FOREIGN KEY (product_id) REFERENCES products(product_id);

--создание таблицы customers
CREATE TABLE customers
(
    customer_id SERIAL PRIMARY KEY,
    name        TEXT,
    email       TEXT
);

--создание таблицы products
CREATE TABLE products
(
    product_id SERIAL PRIMARY KEY,
    name       TEXT,
    price      NUMERIC(10, 2)
);