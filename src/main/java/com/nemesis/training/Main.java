package com.nemesis.training;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  private static final String CONFIG_FILE = "config.file";
  private static final String DB_CONNECTION_FILE = "application.properties";

  public static int run(String[] args) {
    try {
      System.setProperty(CONFIG_FILE, DB_CONNECTION_FILE);
      new UserCommand().run(args);
      return 0;
    } catch (ConfigFileException e) {
      log.error("Config file problem: {}", e.getMessage());
      return 1;
    } catch (SQLException e) {
      log.error("Database problem: {}", e.getMessage());
      return 2;
    } catch (IllegalArgumentException | IllegalStateException e) {
      log.error("Input/Validation problem: {}", e.getMessage());
      return 3;
    }
  }

  public static void main(String[] args) {
    int status = run(args);
    System.exit(status);
  }
}
