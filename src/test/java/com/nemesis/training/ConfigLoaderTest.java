package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {

  @Test
  void mustLoadApplicationPropertiesWhenFileExists() {
    // Arrange
    String fileName = "application.properties";

    // Act
    Properties props = ConfigLoader.load(fileName);

    // Assert
    assertFalse(props.isEmpty());
  }

  @Test
  void mustThrowIllegalArgumentExceptionWhenFileDoesNotExist() {
    // Arrange
    String fileName = "foo.properties";

    // Act + Assert
    assertThrows(IllegalArgumentException.class, () -> ConfigLoader.load(fileName));
  }

  @Test
  void mustThrowIllegalStateExceptionWhenFileIsEmpty() {
    // Arrange
    String fileName = "empty.properties";

    // Act + Assert
    assertThrows(IllegalStateException.class, () -> ConfigLoader.load(fileName));
  }

  @Test
  void mustReturnNonNullPropertiesWhenGetPropertyIsCalled() {
    // Arrange
    System.setProperty("config.file", "application.properties");

    // Act
    Properties props = ConfigLoader.loadSystemPropertyAndLoad();

    // Assert
    assertNotNull(props);
  }

  @Test
  void mustReturnNonEmptyPropertiesWhenGetPropertyIsCalled() {
    // Arrange
    System.setProperty("config.file", "application.properties");

    // Act
    Properties props = ConfigLoader.loadSystemPropertyAndLoad();

    // Assert
    assertFalse(props.isEmpty());
  }
}
