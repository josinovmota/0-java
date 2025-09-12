package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

  private User user;
  private final String name = "Tiberius";

  @BeforeEach
  void setUp() {
      user = new User(name);
  }

  @Test
  void mustSetIdWhenIdIsPassed() {
    // Act
    user.setId(1L);

    // Assert
    assertEquals(1L, user.getId());
  }

  @Test
  void mustSetUsernameWhenUsernameIsPassed() {
    // Assert
    assertEquals("Tiberius", user.getName());
  }
}
