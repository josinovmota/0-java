package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

  private User user;
  private String name;

  @BeforeEach
  void setUp() {
      name = "Tiberius";
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
