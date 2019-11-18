CREATE TABLE products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    category TEXT,
    count INTEGER CHECK ( count >= 0 ),
    status TEXT CHECK( status IN ('Make buy','not available') ) NOT NULL DEFAULT 'Make buy',
    price INTEGER NOT NULL CHECK ( price > 0 )
);

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    login TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL
);

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    count INTEGER CHECK ( count > 0 ),
    name TEXT NOT NULL,
    product_cost INTEGER,
    status TEXT CHECK( status IN ('Bought','Not bought') ) NOT NULL DEFAULT 'Bought'
);

CREATE TABLE sales
(
    orders_id INTEGER REFERENCES orders (id),
    productId INTEGER REFERENCES products (id),
    number    INTEGER NOT NULL CHECK ( number > 0 )
);

INSERT INTO users
VALUES ('user1', 'user123'),
       ('user2', 'user321'),
       ('user3', 'user111'),
       ('user4', 'user222');

INSERT INTO products
VALUES ('iPhone', 'Phones', 5, '', 100000),
       ('Xiaomi', 'Phones', 2, '', 20000),
       ('LG', 'TVs', 1, '', 15000),
       ('Samsung', 'TVs', 0, '', 200000),
       ('Philips', 'PC', 4, '', 19000);

INSERT INTO orders
VALUES (1, 2, 'iPhone', 100000, 'Bought');

INSERT INTO sales(orders_id, productId, number)
VALUES (1, 1, 1),
       (1, 3, 2),
       (1, 5, 3);