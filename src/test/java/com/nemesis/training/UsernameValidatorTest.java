package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsernameValidatorTest {

  private List<String> usernames;

  @BeforeEach
  void setUp() {
    usernames = new ArrayList<>();
  }

  @Test
  void mustValidateUsernameWhenUsernameIsValid() {
    usernames.add("josinobereteu");
    usernames.add("guilhermepapao");

    assertFalse(UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsEmpty() {
    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsNull() {
    usernames = null;

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsNotAlphabetic() {
    usernames.add("12346326");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsNotLowerCase() {
    usernames.add("GERALDAO");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsUndersized() {
    usernames.add("ana");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsOversized() {
    usernames.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameInvalid(usernames));
  }
}
