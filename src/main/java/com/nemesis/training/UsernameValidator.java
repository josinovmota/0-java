package com.nemesis.training;

import java.util.ArrayList;
import java.util.List;

public class UsernameValidator {

  public static boolean isUsernameInvalid(List<String> usernames) {

    List<String> notAlphabetic = new ArrayList<>();
    List<String> notLowerCase = new ArrayList<>();
    List<String> undersizedUsernames = new ArrayList<>();
    List<String> oversizedUsernames = new ArrayList<>();

    if (usernames == null || usernames.isEmpty()) {
      throw new IllegalArgumentException("ERROR: At least one argument must be passed");
    }

    // Checks if arguments are according to the constraints and add wrong ones to validation lists
    for (String username : usernames) {
      // Checks if the arguments are alphabetic string ( i )
      if (!username.matches("[a-zA-Z]+")) {
        notAlphabetic.add(username);
        // Checks if the arguments are in lower-case ( i )
      } else if (!username.matches("[a-z]+")) {
        notLowerCase.add(username);
        // Checks if the arguments have a minimum length of 8 characters
      } else if (username.length() < 8) {
        undersizedUsernames.add(username);
        // Checks if the arguments have a maximum length of 25 characters
      } else if (username.length() > 25) {
        oversizedUsernames.add(username);
      }
    }

    // Validation variable to look for errors
    boolean hasErrors = false;

    // Raises an error if there are non-alphabetic arguments being passed
    if (!notAlphabetic.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments are not alphabetic: " + notAlphabetic);
    }

    // Raises an error if there are non-lowercase arguments being passed
    if (!notLowerCase.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must be lowercase: " + notLowerCase);
    }

    // Raises an error if there are undersized arguments being passed
    if (!undersizedUsernames.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a minimum length of 8 characters: "
              + undersizedUsernames);
    }

    // Raises an error if there are oversized arguments being passed
    if (!oversizedUsernames.isEmpty()) {
      hasErrors = true;
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a maximum length of 25 characters: "
              + oversizedUsernames);
    }

    return hasErrors;
  }
}
