package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class UserCommandTest {

  @Test
  void mustReturnNothingWhenUserIsInvalid() {
    // Arrange
    UserCommand user = new UserCommand();
    user.usernames = new ArrayList<>();
    user.usernames.add("a");

    // Act + Assert
    assertThrows(IllegalArgumentException.class, () -> user.run());
  }

  @Test
  void mustReturnNothingWhenUserIsValid() {
    // Arrange
    UserCommand user = new UserCommand();
    user.usernames = new ArrayList<>();
    user.usernames.add("josinobereteu");

    // Act + Assert
    assertDoesNotThrow(() -> user.run());
  }
}
