package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class MainTest {

  @Test
  void mustExecuteMainWhenArgsArePassed() {
    // Arrange
    String[] args = {"josinobereteu", "guilhermelegal"};

    // Act
    int testMain = new CommandLine(new UserCommand()).execute(args);

    // Arrange
    assertEquals(0, testMain);
  }
}
