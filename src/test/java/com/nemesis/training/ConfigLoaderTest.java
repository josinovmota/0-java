package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {

  @Test
  void mustThrowIllegalArgumentExceptionWhenFileNameIsNull() {
    String fileName = null;

    assertThrows(IllegalArgumentException.class, () -> ConfigLoader.load(fileName));
  }

  @Test
  void mustThrowIllegalArgumentExceptionWhenFileNameIsBlank() {
    String fileName = "";

    assertThrows(IllegalArgumentException.class, () -> ConfigLoader.load(fileName));
  }

  @Test
  void mustThrowConfigFileExceptionWhenFileDoesNotExist() {
    String fileName = "uau.properties";

    assertThrows(ConfigFileException.class, () -> ConfigLoader.load(fileName));
  }

  @Test
  void mustLoadPropertiesWhenFileExists() {
    String fileName = "application.properties";

    assertDoesNotThrow(() -> ConfigLoader.load(fileName));
  }

  @Test
  void shouldThrowIllegalStateExceptionWhenFileIsEmpty() {
    // Arrange
    String fileName = "empty.properties";

    // Act + Assert
    assertThrows(
        ConfigFileException.class,
        () -> {
          ConfigLoader.load(fileName);
        });
  }

  @Test
  void mustLoadSystemPropertyAndLoadWhenPropertiesAreValid() throws ConfigFileException {
    System.setProperty("config.file", "application.properties");

    Properties props = ConfigLoader.loadSystemPropertyAndLoad();

    assertFalse(props.isEmpty());
  }
}
