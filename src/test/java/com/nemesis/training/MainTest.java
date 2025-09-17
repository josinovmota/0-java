package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class MainTest {

  @Test
  void mustExecuteMainWhenMainMethodIsCalled() {
    // Arrange
    String[] args = {"josinobereteu", "guilhermelegal"};

    // Arrange
      assertDoesNotThrow(() -> Main.main(args));
  }
}
