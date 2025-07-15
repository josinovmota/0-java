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

    public long save(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(h2Url, h2Username, h2Password)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                                    "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                                    "name VARCHAR(255) NOT NULL)";

            try(Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                String insertSQL = "INSERT INTO users (name) VALUES (?)";

                try(PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                    pstmt.setString(1, user.getName());
                    pstmt.executeUpdate();

                    try(ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            return rs.getLong(1);
                        } else {
                            throw new RuntimeException("It was possible to obtain the id");
                        }

                    }
                }
            }
        }

    }


}
