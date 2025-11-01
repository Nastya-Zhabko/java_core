--Тяжелый запрос №1 до оптимизации
SELECT o.order_id, c.name, p.name, o.amount
FROM orders o
         JOIN customers c ON o.customer_id = c.customer_id
         JOIN products p ON o.product_id = p.product_id
WHERE o.created_at BETWEEN '2025-01-01' AND '2025-01-31';

-- План выполнения №1

-- Gather  (cost=480809.28..956456.43 rows=2525602 width=39) (actual time=1878.055..3924.829 rows=2462721.00 loops=1)
--   Workers Planned: 2
--   Workers Launched: 2
--   Buffers: shared hit=14134 read=354667, temp read=65020 written=65292
--   ->  Parallel Hash Join  (cost=479809.28..702896.23 rows=1052334 width=39) (actual time=1758.562..3440.602 rows=820907.00 loops=3)
--         Hash Cond: (o.product_id = p.product_id)
--         Buffers: shared hit=14134 read=354667, temp read=65020 written=65292
--         ->  Parallel Hash Join  (cost=475711.23..696035.74 rows=1052334 width=30) (actual time=1539.737..2744.587 rows=820909.00 loops=3)
--               Hash Cond: (c.customer_id = o.customer_id)
--               Buffers: shared hit=12683 read=354667, temp read=65020 written=65292
--               ->  Parallel Seq Scan on customers c  (cost=0.00..140117.53 rows=4166253 width=20) (actual time=1.801..280.288 rows=3333333.33 loops=3)
--                     Buffers: shared hit=95 read=98360
--               ->  Parallel Hash  (cost=456390.05..456390.05 rows=1052334 width=18) (actual time=579.326..579.330 rows=820909.33 loops=3)
--                     Buckets: 131072  Batches: 32  Memory Usage: 5312kB
--                     Buffers: shared hit=12588 read=256307, temp written=11840
--                     ->  Parallel Seq Scan on orders o  (cost=0.00..456390.05 rows=1052334 width=18) (actual time=0.529..422.850 rows=820909.33 loops=3)
--                           Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at <= '2025-01-31 00:00:00'::timestamp without time zone))
--                           Rows Removed by Filter: 9179091
--                           Buffers: shared hit=12588 read=256307
--         ->  Parallel Hash  (cost=2627.47..2627.47 rows=117647 width=17) (actual time=215.875..215.877 rows=66666.67 loops=3)
--               Buckets: 262144  Batches: 1  Memory Usage: 13056kB
--               Buffers: shared hit=1451
--               ->  Parallel Seq Scan on products p  (cost=0.00..2627.47 rows=117647 width=17) (actual time=164.045..168.785 rows=66666.67 loops=3)
--                     Buffers: shared hit=1451
-- Planning:
--   Buffers: shared hit=16
-- Planning Time: 0.804 ms
-- JIT:
--   Functions: 60
--   Options: Inlining true, Optimization true, Expressions true, Deforming true
--   Timing: Generation 6.130 ms (Deform 2.561 ms), Inlining 133.521 ms, Optimization 221.343 ms, Emission 137.617 ms, Total 498.612 ms
-- Execution Time: 4086.326 ms

--Тяжелый запрос №2 до оптимизации
SELECT * FROM orders WHERE created_at >= '2025-01-01' AND created_at
    <'2025-02-01';

-- План выполнения №2

-- Seq Scan on orders  (cost=0.00..718883.12 rows=2609131 width=35) (actual time=13.010..1932.894 rows=2545198.00 loops=1)
--   Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at < '2025-02-01 00:00:00'::timestamp without time zone))
--   Rows Removed by Filter: 27454802
--   Buffers: shared hit=12964 read=255931
-- Planning Time: 0.067 ms
-- JIT:
--   Functions: 2
--   Options: Inlining true, Optimization true, Expressions true, Deforming true
--   Timing: Generation 0.303 ms (Deform 0.077 ms), Inlining 1.710 ms, Optimization 6.118 ms, Emission 5.157 ms, Total 13.288 ms
-- Execution Time: 2031.619 ms



--Создание индекса по полю created_at таблицы orders
CREATE INDEX idx_orders_created_at ON orders (created_at);

--План выполнения запроса №1

-- Gather  (cost=480161.67..941879.23 rows=2390593 width=39) (actual time=3291.012..4798.329 rows=2462721.00 loops=1)
--   Workers Planned: 2
--   Workers Launched: 2
-- "  Buffers: shared hit=11175 read=357626, temp read=65022 written=65328"
--   ->  Parallel Hash Join  (cost=479161.67..701819.93 rows=996080 width=39) (actual time=3270.398..4466.714 rows=820907.00 loops=3)
--         Hash Cond: (o.product_id = p.product_id)
-- "        Buffers: shared hit=11175 read=357626, temp read=65022 written=65328"
--         ->  Parallel Hash Join  (cost=475063.61..695051.80 rows=1017148 width=30) (actual time=3100.497..3952.947 rows=820909.00 loops=3)
--               Hash Cond: (c.customer_id = o.customer_id)
-- "              Buffers: shared hit=11175 read=356175, temp read=65022 written=65328"
--               ->  Parallel Seq Scan on customers c  (cost=0.00..140123.71 rows=4166871 width=20) (actual time=0.954..323.285 rows=3333333.33 loops=3)
--                     Buffers: shared hit=11175 read=87280
--               ->  Parallel Hash  (cost=456389.26..456389.26 rows=1017148 width=18) (actual time=2105.106..2105.107 rows=820909.33 loops=3)
--                     Buckets: 131072  Batches: 32  Memory Usage: 5312kB
-- "                    Buffers: shared read=268895, temp written=11872"
--                     ->  Parallel Seq Scan on orders o  (cost=0.00..456389.26 rows=1017148 width=18) (actual time=1.622..1912.379 rows=820909.33 loops=3)
--                           Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at <= '2025-01-31 00:00:00'::timestamp without time zone))
--                           Rows Removed by Filter: 9179091
--                           Buffers: shared read=268895
--         ->  Parallel Hash  (cost=2627.47..2627.47 rows=117647 width=17) (actual time=169.023..169.024 rows=66666.67 loops=3)
--               Buckets: 262144  Batches: 1  Memory Usage: 13024kB
--               Buffers: shared read=1451
--               ->  Parallel Seq Scan on products p  (cost=0.00..2627.47 rows=117647 width=17) (actual time=137.206..141.990 rows=66666.67 loops=3)
--                     Buffers: shared read=1451
-- Planning:
--   Buffers: shared hit=21 read=12 dirtied=1
-- Planning Time: 4.586 ms
-- JIT:
--   Functions: 60
-- "  Options: Inlining true, Optimization true, Expressions true, Deforming true"
-- "  Timing: Generation 2.554 ms (Deform 0.943 ms), Inlining 118.416 ms, Optimization 175.179 ms, Emission 117.565 ms, Total 413.714 ms"
-- Execution Time: 4907.459 ms

-- План выполнения запроса №2

-- Gather  (cost=1000.00..709438.96 rows=2520497 width=35) (actual time=23.987..1949.356 rows=2545198.00 loops=1)
--   Workers Planned: 2
--   Workers Launched: 2
--   Buffers: shared hit=282 read=268613
--   ->  Parallel Seq Scan on orders  (cost=0.00..456389.26 rows=1050207 width=35) (actual time=56.535..1793.276 rows=848399.33 loops=3)
--         Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at < '2025-02-01 00:00:00'::timestamp without time zone))
--         Rows Removed by Filter: 9151601
--         Buffers: shared hit=282 read=268613
-- Planning:
--   Buffers: shared hit=1 read=2
-- Planning Time: 1.295 ms
-- JIT:
--   Functions: 6
-- "  Options: Inlining true, Optimization true, Expressions true, Deforming true"
-- "  Timing: Generation 1.308 ms (Deform 0.394 ms), Inlining 128.550 ms, Optimization 18.748 ms, Emission 19.690 ms, Total 168.297 ms"
-- Execution Time: 2049.467 ms

--ИТОГ: время выполнения увеличилось, продолжает выполняться Seq Scan.
--При добавлении индексов по полям customer_id и product_id время еще больше увеличивалось.
--Причина не понятна, прошу объяснить

--ПАРТИЦИОНИРОВАНИЕ

-- Создание новой таблицы, поддерживающей партиционирование
DROP INDEX idx_orders_crated_at;
ALTER TABLE orders RENAME TO orders_old;
CREATE TABLE orders (
                        order_id SERIAL,
                        customer_id INT,
                        product_id INT,
                        created_at TIMESTAMP NOT NULL,
                        amount NUMERIC(10,2),
                        status TEXT,
                        PRIMARY KEY (order_id, created_at)
) PARTITION BY RANGE (created_at);

--Создание партиций
CREATE TABLE orders_2025_01 PARTITION OF orders
    FOR VALUES FROM ('2025-01-01') TO ('2025-02-01');
CREATE TABLE orders_2025_02 PARTITION OF orders
    FOR VALUES FROM ('2025-02-01') TO ('2025-03-01');
CREATE TABLE orders_2025_03 PARTITION OF orders
    FOR VALUES FROM ('2025-03-01') TO ('2025-04-01');
CREATE TABLE orders_2025_04 PARTITION OF orders
    FOR VALUES FROM ('2025-04-01') TO ('2025-05-01');
CREATE TABLE orders_2025_05 PARTITION OF orders
    FOR VALUES FROM ('2025-05-01') TO ('2025-06-01');
CREATE TABLE orders_2025_06 PARTITION OF orders
    FOR VALUES FROM ('2025-06-01') TO ('2025-07-01');
CREATE TABLE orders_2025_07 PARTITION OF orders
    FOR VALUES FROM ('2025-07-01') TO ('2025-08-01');
CREATE TABLE orders_2025_08 PARTITION OF orders
    FOR VALUES FROM ('2025-08-01') TO ('2025-09-01');
CREATE TABLE orders_2025_09 PARTITION OF orders
    FOR VALUES FROM ('2025-09-01') TO ('2025-10-01');
CREATE TABLE orders_2025_10 PARTITION OF orders
    FOR VALUES FROM ('2025-10-01') TO ('2025-11-01');
CREATE TABLE orders_2025_11 PARTITION OF orders
    FOR VALUES FROM ('2025-11-01') TO ('2025-12-01');
CREATE TABLE orders_2025_12 PARTITION OF orders
    FOR VALUES FROM ('2025-12-01') TO ('2026-01-01');


-- Заполнение новой таблицы данными скриптом из seed.sql и создание индексов
CREATE INDEX idx_orders_crated_at ON orders (created_at);

-- План выполнения запроса №1

-- Gather  (cost=221723.66..548514.07 rows=2462392 width=39) (actual time=1397.600..2502.375 rows=2462615.00 loops=1)
--   Workers Planned: 2
--   Workers Launched: 2
-- "  Buffers: shared hit=3036 read=119686, temp read=65262 written=66156"
--   ->  Parallel Hash Join  (cost=220723.66..301274.87 rows=1025997 width=39) (actual time=1370.897..2153.790 rows=820871.67 loops=3)
--         Hash Cond: (o.product_id = p.product_id)
-- "        Buffers: shared hit=3036 read=119686, temp read=65262 written=66156"
--         ->  Parallel Hash Join  (cost=216625.60..294483.51 rows=1025997 width=30) (actual time=1215.790..1698.749 rows=820874.67 loops=3)
--               Hash Cond: (o.customer_id = c.customer_id)
-- "              Buffers: shared hit=1585 read=119686, temp read=65262 written=66156"
--               ->  Parallel Seq Scan on orders_2025_01 o  (cost=0.00..38724.67 rows=1025997 width=18) (actual time=0.164..69.955 rows=820874.67 loops=3)
--                     Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at <= '2025-01-31 00:00:00'::timestamp without time zone))
--                     Rows Removed by Filter: 27588
--                     Buffers: shared hit=334 read=22482
--               ->  Parallel Hash  (cost=140123.71..140123.71 rows=4166871 width=20) (actual time=975.361..975.362 rows=3333333.33 loops=3)
--                     Buckets: 131072  Batches: 128  Memory Usage: 5376kB
-- "                    Buffers: shared hit=1251 read=97204, temp written=53624"
--                     ->  Parallel Seq Scan on customers c  (cost=0.00..140123.71 rows=4166871 width=20) (actual time=0.729..261.441 rows=3333333.33 loops=3)
--                           Buffers: shared hit=1251 read=97204
--         ->  Parallel Hash  (cost=2627.47..2627.47 rows=117647 width=17) (actual time=153.939..153.940 rows=66666.67 loops=3)
--               Buckets: 262144  Batches: 1  Memory Usage: 13056kB
--               Buffers: shared hit=1451
--               ->  Parallel Seq Scan on products p  (cost=0.00..2627.47 rows=117647 width=17) (actual time=126.477..130.479 rows=66666.67 loops=3)
--                     Buffers: shared hit=1451
-- Planning:
--   Buffers: shared hit=4
-- Planning Time: 0.429 ms
-- JIT:
--   Functions: 60
-- "  Options: Inlining true, Optimization true, Expressions true, Deforming true"
-- "  Timing: Generation 3.471 ms (Deform 1.322 ms), Inlining 114.802 ms, Optimization 157.583 ms, Emission 107.244 ms, Total 383.100 ms"
-- Execution Time: 2607.582 ms


-- План выполнения запроса №2

-- Seq Scan on orders_2025_01 orders  (cost=0.00..60996.81 rows=2545387 width=35) (actual time=0.012..195.007 rows=2545387.00 loops=1)
--   Filter: ((created_at >= '2025-01-01 00:00:00'::timestamp without time zone) AND (created_at < '2025-02-01 00:00:00'::timestamp without time zone))
--   Buffers: shared hit=616 read=22200
-- Planning:
--   Buffers: shared hit=17 dirtied=1
-- Planning Time: 0.697 ms
-- Execution Time: 281.002 ms


--ИТОГ: время выполнения запросов значительно сократилось, поиск выполняется только по партиции orders_2025_01

--ТРАНЗАКЦИИ И БЛОКИРОВКИ

-- Результаты EXPLAIN для второго запроса UPDATE orders SET status = 'processing' WHERE order_id=12345;

-- Update on orders  (cost=0.43..101.43 rows=0 width=0)
-- Update on orders_2025_01 orders_1
-- Update on orders_2025_02 orders_2
-- Update on orders_2025_03 orders_3
-- Update on orders_2025_04 orders_4
-- Update on orders_2025_05 orders_5
-- Update on orders_2025_06 orders_6
-- Update on orders_2025_07 orders_7
-- Update on orders_2025_08 orders_8
-- Update on orders_2025_09 orders_9
-- Update on orders_2025_10 orders_10
-- Update on orders_2025_11 orders_11
-- Update on orders_2025_12 orders_12
--     ->  Append  (cost=0.43..101.43 rows=12 width=42)
--     ->  Index Scan using orders_2025_01_pkey on orders_2025_01 orders_1  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_02_pkey on orders_2025_02 orders_2  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_03_pkey on orders_2025_03 orders_3  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_04_pkey on orders_2025_04 orders_4  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_05_pkey on orders_2025_05 orders_5  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_06_pkey on orders_2025_06 orders_6  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_07_pkey on orders_2025_07 orders_7  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_08_pkey on orders_2025_08 orders_8  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_09_pkey on orders_2025_09 orders_9  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_10_pkey on orders_2025_10 orders_10  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_11_pkey on orders_2025_11 orders_11  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)
--     ->  Index Scan using orders_2025_12_pkey on orders_2025_12 orders_12  (cost=0.43..8.45 rows=1 width=42)
--     Index Cond: (order_id = 12345)

-- ТРИГГЕР ИЛИ ХРАНИМАЯ ПРОЦЕДУРА

-- После создания триггера для записи обновлений таблицы orders в таблицу orders_audit:
-- Судя по EXPLAIN ANALYSE, время выполнения для одиночных операций UPDATE / INSERT практически не изменилось;
-- После операции UPDATE в таблицу добавляется строка, после INSERT ничего не происходит.










