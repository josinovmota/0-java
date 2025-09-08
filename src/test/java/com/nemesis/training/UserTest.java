package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void mustCreateUserWhenUserIsPassed() {
    // Arrange
    String name = "Tiberius";

    // Act
    User user = new User(name);

    // Assert
    assertEquals(name, user.getName());
  }

  @Test
  void mustSetIdAndUsernameWhenIdAndUsernameIsPassed() {
    // Arrange
    User user = new User("Tiberius");

    // Act
    user.setId(1L);

    // Assert
    assertEquals(1L, user.getId());
    assertEquals("Tiberius", user.getName());
  }
}
