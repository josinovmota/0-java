package com.nemesis.training;

import java.util.ArrayList;
import java.util.List;

public class UsernameValidator {

  static final int ARGUMENT_MINIMUM_LENGTH = 8;
  static final int ARGUMENT_MAXIMUM_LENGTH = 25;

  public static boolean isUsernameValid(List<String> usernames) {

    List<String> NOT_ALPHABETIC = new ArrayList<>();
    List<String> NOT_LOWER_CASE = new ArrayList<>();
    List<String> UNDERSIZED_USERNAMES = new ArrayList<>();
    List<String> OVERSIZED_USERNAMES = new ArrayList<>();

    if (usernames == null || usernames.isEmpty()) {
      throw new IllegalArgumentException("ERROR: At least one argument must be passed");
    }

    // Checks if arguments are according to the constraints and add wrong ones to validation lists
    for (String username : usernames) {
      // Checks if the arguments are alphabetic string ( i )
      if (!username.matches("[a-zA-Z]+")) {
        NOT_ALPHABETIC.add(username);
        // Checks if the arguments are in lower-case ( i )
      } else if (!username.matches("[a-z]+")) {
        NOT_LOWER_CASE.add(username);
        // Checks if the arguments have a minimum length of 8 characters
      } else if (!username.matches("^.{8,}$")) {
        UNDERSIZED_USERNAMES.add(username);
        // Checks if the arguments have a maximum length of 25 characters
      } else if (!username.matches("^.{0,25}$")) {
        OVERSIZED_USERNAMES.add(username);
      }
    }

    // Validation variable to look for errors
    boolean hasErrors = false;

    // Raises an error if there are non-alphabetic arguments being passed
    if (!NOT_ALPHABETIC.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments are not alphabetic: " + NOT_ALPHABETIC);
    }

    // Raises an error if there are non-lowercase arguments being passed
    if (!NOT_LOWER_CASE.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must be lowercase: " + NOT_LOWER_CASE);
    }

    // Raises an error if there are undersized arguments being passed
    if (!UNDERSIZED_USERNAMES.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a minimum length of 8 characters: "
              + UNDERSIZED_USERNAMES);
    }

    // Raises an error if there are oversized arguments being passed
    if (!OVERSIZED_USERNAMES.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a maximum length of 25 characters: "
              + OVERSIZED_USERNAMES);
    }

    return hasErrors;
  }
}
