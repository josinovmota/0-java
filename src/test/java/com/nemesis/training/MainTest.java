package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void mustReturnRightPropertyWhenCalled() {
    // Arrange
    String[] args = {"josinobereteu", "guilhermelegal"};

    // Act
    Main.main(args);

    // Arrange
    assertEquals("application.properties", System.getProperty("config.file"));
  }
}
