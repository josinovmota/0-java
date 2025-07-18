package com.nemesis.training;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class UserRepository {

    private String h2Url;
    private String h2Username;
    private String h2Password;

    public UserRepository() {
        Properties props = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");

        try {
            props.load(input);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        this.h2Url = props.getProperty("db.url");
        this.h2Username = props.getProperty("db.username");
        this.h2Password = props.getProperty("db.password");
    }

    // create a class that will use JDBC to persist the `User` `name` in the H2 database and return the id
    public long save(User user) throws SQLException {
        try (Connection connection = DriverManager.getConnection(h2Url, h2Username, h2Password)) {
            createTableIfNotExists(connection);
            String insertSQL = "INSERT INTO users (name) VALUES (?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, user.getName());
                insertStatement.executeUpdate();

                try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    } else {
                        throw new RuntimeException("It was not possible to obtain the id");
                    }

                }
            }
        }
    }

    // Extract createTableSQL to a new method
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL)";
        try (Statement createTableStatement = conn.createStatement()) {
            createTableStatement.execute(createTableSQL);
        }
    }
}