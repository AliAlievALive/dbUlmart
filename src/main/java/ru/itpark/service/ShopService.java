package ru.itpark.service;

import ru.itpark.domain.Users;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {
    private final DataSource ds;

    public ShopService() throws NamingException, SQLException {
        var context = new InitialContext();
        ds = (DataSource) context.lookup("java:/comp/env/jdbc/db");
        try (var conn = ds.getConnection()) {
            try (var stmt = conn.createStatement()){
                stmt.execute("CREATE TABLE IF NOT EXISTS products (" +
                        "id TEXT PRIMARY KEY, " +
                        "name TEXT NOT NULL, " +
                        "category TEXT NOT NULL, " +
                        "count INTEGER NOT NULL CHECK ( count >= 0 ), " +
                        "status TEXT NOT NULL, " +
                        "price NOT NULL CHECK ( price > 0 ));"
                );

                stmt.execute("CREATE TABLE IF NOT EXISTS users (id TEXT PRIMARY KEY, login TEXT NOT NULL, name TEXT NOT NULL);"
                );

                stmt.execute("CREATE TABLE orders (\n" +
                        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    count INTEGER CHECK ( count > 0 ),\n" +
                        "    name TEXT NOT NULL,\n" +
                        "    product_cost INTEGER,\n" +
                        "    total_cost INTEGER," +
                        "    status INTEGER NOT NULL CHECK ( status >= 0 ));"
                );
            }
        }
    }

    public List<Users> getAll() throws SQLException {
        try (var conn = ds.getConnection()) {
            try (var stmt = conn.createStatement()) {
                try (var rs = stmt.executeQuery("SELECT id, login, name FROM users;")) {
                    var list = new ArrayList<Users>();

                    while (rs.next()) {
                        list.add(new Users(
                                rs.getString("id"),
                                rs.getString("login"),
                                rs.getString("name")
                        ));
                    }
                    return list;
                }
            }
        }
    }

    public void create(String login, String name) throws SQLException {
        try (var conn = ds.getConnection()) {
            try (var stmt = conn.prepareStatement("INSERT INTO users (id, login, name) VALUES (?, ?, ?)")) {
                stmt.setString(1, UUID.randomUUID().toString());
                stmt.setString(2, login);
                stmt.setString(3, name);
                stmt.execute();
            }
        }
    }
}
