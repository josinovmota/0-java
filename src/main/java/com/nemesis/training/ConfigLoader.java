package com.nemesis.training;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigLoader {

  public static Properties load(String fileName) throws ConfigFileException {
    if (fileName == null || fileName.isBlank()) {
      log.error("File: {} is null or empty", fileName);
      throw new IllegalArgumentException("ERROR: File name must not be null or empty");
    }

    Properties props = new Properties();

    try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
      if (input == null) {
        log.error("File: {} is not found", fileName);
        throw new ConfigFileException("ERROR: File not found: " + fileName);
      }

      props.load(input);

      if (props.isEmpty()) {
        log.error("File: {} is empty", fileName);
        throw new IllegalStateException("ERROR: Properties file is empty: " + fileName);
      }

    } catch (IOException e) {
      log.error("File: {} got an unexpected error while loading, {}", fileName, e.getMessage());
      throw new ConfigFileException("ERROR: Unexpected error while loading: " + fileName, e);
    }

    return props;
  }

  public static Properties loadSystemPropertyAndLoad() throws ConfigFileException {
    log.info("Loading system config.file and application.properties");
    return load(System.getProperty("config.file", "application.properties"));
  }
}
