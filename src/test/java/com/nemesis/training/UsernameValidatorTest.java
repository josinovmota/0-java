package com.nemesis.training;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class UsernameValidatorTest {

  @Test
  void mustValidateUsernameWhenUsernameIsValid() {
    List<String> usernames = new ArrayList<>();
    usernames.add("josinobereteu");
    usernames.add("guilhermepapao");

    assertFalse(UsernameValidator.isUsernameValid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsEmpty() {
    List<String> usernames = new ArrayList<>();

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameValid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsNotAlphabetic() {
    List<String> usernames = new ArrayList<>();
    usernames.add("1235423");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameValid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameIsUpperCase() {
    List<String> usernames = new ArrayList<>();
    usernames.add("GUILHERMEPAPAO");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameValid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameHasLessThanMinimumCharacters() {
    List<String> usernames = new ArrayList<>();
    usernames.add("gui");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameValid(usernames));
  }

  @Test
  void mustInvalidateUsernameWhenUsernameHasMoreThanMaximumCharacters() {
    List<String> usernames = new ArrayList<>();
    usernames.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    assertThrows(
        IllegalArgumentException.class, () -> UsernameValidator.isUsernameValid(usernames));
  }
}
