package ru.itpark.service;

import java.sql.*;

public class ShopService {

    private Connection getNewConnection(String url) throws SQLException {
        String user = "sa";
        String password = "sa";
        return DriverManager.getConnection(url, user, password);
    }

    private int executeUpdate(String url, String query) throws SQLException {
        Statement statement = getNewConnection(url).createStatement();
        return statement.executeUpdate(query);
    }

    private void createUsersTable(String url) throws SQLException {
        String usersTableQuery = "CREATE TABLE IF NOT EXISTS users (id TEXT PRIMARY KEY, login TEXT NOT NULL, " +
                "name TEXT NOT NULL, image TEXT);";
        String usersEntryQuery = "INSERT INTO users " +
                "VALUES (1, 'user1', '123'), (2, 'user2', '321'), (3, 'user3', '111'), (4, 'user4', '222');";
        executeUpdate(url, usersTableQuery);
        executeUpdate(url, usersEntryQuery);
    }

    private void createProductTable(String url) throws SQLException {
        String productTableQuery = "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL, category TEXT, count INTEGER CHECK ( count >= 0 )," +
                " status TEXT CHECK( status IN ('Make buy','not available') ) NOT NULL DEFAULT 'Make buy'," +
                " price INTEGER NOT NULL CHECK ( price > 0 ));";
        String productEntryQuery = "INSERT INTO products VALUES (1, 'iPhone', 'Phones', 5, '', 100000), " +
                "(2, 'Xiaomi', 'Phones', 2, '', 20000), (3, 'LG', 'TVs', 1, '', 15000), " +
                "(4, 'Samsung', 'TVs', 0, '', 200000), (5, 'Philips', 'PC', 4, '', 19000);";
        executeUpdate(url, productTableQuery);
        executeUpdate(url, productEntryQuery);
    }

    private void createOrderTable(String url) throws SQLException {
        String orderTableQuery = "id INTEGER PRIMARY KEY AUTOINCREMENT, count INTEGER CHECK ( count > 0 )," +
                " name TEXT NOT NULL, product_cost INTEGER, user_id REFERENCES users, product_id REFERENCES products";
        String orderEntryQuery = "INSERT INTO orders VALUES (1, 2, 'iPhone', 100000, 1, 1, 200000);";
        executeUpdate(url, orderTableQuery);
        executeUpdate(url, orderEntryQuery);
    }
}
