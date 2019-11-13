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

    private void createUsersTable() throws SQLException {
        String url = "java:/comp/env/jdbc/db.sql";
        String usersTableQuery = "CREATE TABLE IF NOT EXISTS users (id TEXT PRIMARY KEY, login TEXT NOT NULL, " +
                "name TEXT NOT NULL, image TEXT);";
        String usersEntryQuery = "INSERT INTO users " +
                "VALUES (1, 'user1', '123'), (2, 'user2', '321'), (3, 'user3', '111'), (4, 'user4', '222');";
        executeUpdate(url, usersTableQuery);
        executeUpdate(url, usersEntryQuery);
    }
}
