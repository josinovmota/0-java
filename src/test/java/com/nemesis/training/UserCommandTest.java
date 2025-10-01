package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserCommandTest {

  @Test
  void mustReturnNothingWhenUserIsInvalid() {
    UserCommand cmd = new UserCommand();
    String[] args = {"a"};

    assertThrows(IllegalArgumentException.class, () -> cmd.run(args));
  }

  @Test
  void mustReturnNothingWhenUserIsValid() {
    UserCommand cmd = new UserCommand();
    String[] args = {"josinobereteu"};

    // Act + Assert
    assertDoesNotThrow(() -> cmd.run(args));
  }
}
