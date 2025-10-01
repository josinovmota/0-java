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
    user.setId(1L);
  }

  @Test
  void mustReturnIdWhenGetIdIsUsed() {
    assertEquals(1L, user.getId());
  }

  @Test
  void mustCreateUserWithCorrectNameWhenNameIsPassed() {
    assertEquals("Tiberius", user.getName());
  }

  @Test
  void mustSetIdWhenSetIdIsUsed() {
    user.setId(2L);

    assertEquals(2L, user.getId());
  }

  @Test
  void setName() {
    user.setName("Josino");

    assertEquals("Josino", user.getName());
  }
}
