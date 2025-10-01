package com.nemesis.training;

public class ConfigFileException extends Exception {
  public ConfigFileException(String message) {
    super(message);
  }

  public ConfigFileException(String message, Throwable cause) {
    super(message, cause);
  }
}
