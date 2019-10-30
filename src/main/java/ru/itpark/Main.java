package ru.itpark;

import java.sql.*;

public class Main {
    /*public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:ulmart.db")) {
            try (Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM managers")){
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("id"));
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getInt("salary"));
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
