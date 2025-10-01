package com.nemesis.training;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

  public static Properties load(String fileName) throws ConfigFileException {
    if (fileName == null || fileName.isBlank()) {
      throw new IllegalArgumentException("ERROR: File name must not be null or empty");
    }

    Properties props = new Properties();

    try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
      if (input == null) {
        throw new ConfigFileException("ERROR: File not found: " + fileName);
      }

      props.load(input);

      if (props.isEmpty()) {
        throw new IllegalStateException("ERROR: Properties file is empty: " + fileName);
      }

    } catch (Exception e) {
      throw new ConfigFileException("ERROR: Unexpected error while loading: " + fileName, e);
    }

    return props;
  }

  public static Properties loadSystemPropertyAndLoad() throws ConfigFileException {
    return load(System.getProperty("config.file", "application.properties"));
  }
}
