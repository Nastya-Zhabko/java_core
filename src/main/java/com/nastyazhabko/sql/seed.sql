--Заполнение таблицы customers
INSERT INTO customers (name, email)
SELECT
    'Customer_' || gs AS name,
    'customer_' || gs ||
    CASE (gs % 5)
        WHEN 0 THEN '@gmail.com'
        WHEN 1 THEN '@yahoo.com'
        WHEN 2 THEN '@hotmail.com'
        WHEN 3 THEN '@outlook.com'
        ELSE '@company.com'
        END AS email
FROM generate_series(1, 10000000) gs;

--Заполнение таблицы products
INSERT INTO products (name, price)
SELECT
    'Product_' || gs AS name,
    round((random() * 9998 + 1)::numeric, 2) AS price
FROM generate_series(1, 100000) gs;

--Заполнение таблицы orders
INSERT INTO orders (customer_id, product_id, created_at, amount, status)
SELECT
    (random() * (SELECT MAX(customer_id) FROM customers) + 1)::int AS customer_id,
        (random() * (SELECT MAX(product_id) FROM products) + 1)::int AS product_id,
        '2025-01-01'::timestamp + (random() * 365 * interval '1 day') AS created_at,
        round((random() * 9990 + 10)::numeric, 2) AS amount,
    (array['pending','completed','shipped','cancelled','processing'])[(random()*4)::int + 1] AS status
FROM generate_series(1, 30000000) gs;