CREATE TABLE products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    category TEXT,
    count INTEGER CHECK ( count >= 0 ),
    status TEXT DEFAULT 'Make buy',
    price INTEGER NOT NULL CHECK ( price > 0 ));

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    count INTEGER CHECK ( count > 0 ),
    name TEXT NOT NULL,
    product_cost INTEGER,
    users_id REFERENCES users,
    product_id REFERENCES products,
    total_cost INTEGER
);

INSERT INTO users
VALUES (1, 'user1', '123'),
       (2, 'user2', '321'),
       (3, 'user3', '111'),
       (4, 'user4', '222');

INSERT INTO products
VALUES (1, 'iPhone', 'Phones', 5, '', 100000),
       (2, 'Xiaomi', 'Phones', 2, '', 20000),
       (3, 'LG', 'TVs', 1, '', 15000),
       (4, 'Samsung', 'TVs', 0, '', 200000),
       (5, 'Philips', 'PC', 4, '', 19000);

INSERT INTO orders
VALUES (1, 2, 'iPhone', 100000, 1, 1, 200000);