package com.nemesis.training;

import java.sql.*;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class UserRepository {

  private String h2Url;
  private String h2Username;
  private String h2Password;

  public UserRepository(Properties props) {
    this.h2Url = props.getProperty("db.url");
    this.h2Username = props.getProperty("db.username");
    this.h2Password = props.getProperty("db.password");
  }

  public UserRepository() throws ConfigFileException {
    this(ConfigLoader.loadSystemPropertyAndLoad());
  }

  public void connect() throws SQLException {
    log.info("Connecting to the in-memory h2 database");
    try (Connection connection = DriverManager.getConnection(h2Url, h2Username, h2Password)) {
      createTableIfNotExists(connection);
    } catch (SQLException e) {
      log.error("The `users` table was not able to be created");
      throw new SQLDataException("ERROR: Can't create the table `users`", e);
    }
  }

  public long save(User user) throws SQLException {
    String insertSQL = "INSERT INTO users (username) VALUES (?)";

    try (Connection connection = DriverManager.getConnection(h2Url, h2Username, h2Password)) {

      try (PreparedStatement insertStatement =
          connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
        insertStatement.setString(1, user.getName());
        insertStatement.executeUpdate();

        try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
          } else {
            log.error("It was not possible to obtain the id");
            throw new SQLDataException("ERROR: It was not possible to obtain the id");
          }
        }
      }
    }
  }

  public void createTableIfNotExists(Connection conn) throws SQLException {
    String createTableSQL =
        "CREATE TABLE IF NOT EXISTS users ("
            + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
            + "username VARCHAR(26) NOT NULL)";
    try (Statement createTableStatement = conn.createStatement()) {
      createTableStatement.execute(createTableSQL);
    }
  }
}
