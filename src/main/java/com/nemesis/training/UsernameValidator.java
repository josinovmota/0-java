package com.nemesis.training;

import java.util.ArrayList;
import java.util.List;
import picocli.CommandLine;

public class UsernameValidator {
  @CommandLine.Parameters List<String> usernames;

  static final int ARGUMENT_MINIMUM_LENGTH = 8;
  static final int ARGUMENT_MAXIMUM_LENGTH = 25;

  List<String> NOT_ALPHABETIC = new ArrayList<>();
  List<String> NOT_LOWER_CASE = new ArrayList<>();
  List<String> UNDERSIZED_USERNAMES = new ArrayList<>();
  List<String> OVERSIZED_USERNAMES = new ArrayList<>();

  public boolean validate() {
    if (usernames == null || usernames.isEmpty()) {
      System.err.println("ERROR: At least one argument must be passed");
      return false;
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
      } else if (username.length() < ARGUMENT_MINIMUM_LENGTH) {
        UNDERSIZED_USERNAMES.add(username);
        // Checks if the arguments have a maximum length of 8 characters
      } else if (username.length() > ARGUMENT_MAXIMUM_LENGTH) {
        OVERSIZED_USERNAMES.add(username);
      }
    }

    // Validation variable to look for errors
    boolean hasErrors = false;

    // Raises an error if there are non-alphabetic arguments being passed
    if (!NOT_ALPHABETIC.isEmpty()) {
      System.err.println("ERROR: These arguments are not alphabetic: " + NOT_ALPHABETIC);
      hasErrors = true;
    }

    // Raises an error if there are non-lowercase arguments being passed
    if (!NOT_LOWER_CASE.isEmpty()) {
      System.err.println("ERROR: These arguments must be lowercase: " + NOT_LOWER_CASE);
      hasErrors = true;
    }

    // Raises an error if there are undersized arguments being passed
    if (!UNDERSIZED_USERNAMES.isEmpty()) {
      System.err.println(
          "ERROR: These arguments must have a minimum length of 8 characters: "
              + UNDERSIZED_USERNAMES);
      hasErrors = true;
    }

    // Raises an error if there are oversized arguments being passed
    if (!OVERSIZED_USERNAMES.isEmpty()) {
      System.err.println(
          "ERROR: These arguments must have a maximum length of 25 characters: "
              + OVERSIZED_USERNAMES);
      hasErrors = true;
    }

    return hasErrors;
  }
}
