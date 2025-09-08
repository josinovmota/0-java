package com.nemesis.training;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class ConfigLoader {
  public static Properties load(String fileName) {
    Properties props = new Properties();

    try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
      if (input == null) {
        throw new IllegalArgumentException("ERROR: File not found: " + fileName);
      }
      props.load(input);

      if (props.isEmpty()) {
        throw new IllegalStateException("ERROR: Properties file is empty: " + fileName);
      }

    } catch (IOException e) {
      throw new UncheckedIOException("ERROR: Error while loading: " + fileName, e);
    }
    return props;
  }

  public static Properties loadSystemPropertyAndLoad() {
    return load(System.getProperty("config.file", "application.properties"));
  }
}
