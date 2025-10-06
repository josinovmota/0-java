package com.nemesis.training;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsernameValidator {

  public static boolean isUsernameInvalid(List<String> usernames) {

    List<String> notAlphabetic = new ArrayList<>();
    List<String> notLowerCase = new ArrayList<>();
    List<String> undersizedUsernames = new ArrayList<>();
    List<String> oversizedUsernames = new ArrayList<>();

    if (usernames == null || usernames.isEmpty()) {
      log.error("List of usernames is Empty or Null - at least one username is required ");
      throw new IllegalArgumentException("ERROR: At least one argument must be passed");
    }

    // Checks if arguments are according to the constraints and add wrong ones to validation lists
    for (String username : usernames) {
      // Checks if the arguments are alphabetic string ( i )
      if (!username.matches("[a-zA-Z]+")) {
        log.debug("The username {} is not alphabetic", username);
        notAlphabetic.add(username);
        // Checks if the arguments are in lower-case ( i )
      } else if (!username.matches("[a-z]+")) {
        log.debug("The username {} is not in lowercase", username);
        notLowerCase.add(username);
        // Checks if the arguments have a minimum length of 8 characters
      } else if (username.length() < 8) {
        log.debug("The username {} is undersized - less than minimum 8 characters", username);
        undersizedUsernames.add(username);
        // Checks if the arguments have a maximum length of 25 characters
      } else if (username.length() > 25) {
        log.debug("The username {} is oversized - more than maximum 25 characters", username);
        oversizedUsernames.add(username);
      }
    }

    // Validation variable to look for errors
    boolean hasErrors = false;

    // Raises an error if there are non-alphabetic arguments being passed
    if (!notAlphabetic.isEmpty()) {
      hasErrors = true;
      log.error("There was non-alphabetic usernames in the list");
      throw new IllegalArgumentException(
          "ERROR: These arguments are not alphabetic: " + notAlphabetic);
    }

    // Raises an error if there are non-lowercase arguments being passed
    if (!notLowerCase.isEmpty()) {
      hasErrors = true;
      log.error("There was non-lowercase usernames in the list");
      throw new IllegalArgumentException(
          "ERROR: These arguments must be lowercase: " + notLowerCase);
    }

    // Raises an error if there are undersized arguments being passed
    if (!undersizedUsernames.isEmpty()) {
      hasErrors = true;
      log.error("There was undersized usernames in the list - less than minimum 8 characters");
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a minimum length of 8 characters: "
              + undersizedUsernames);
    }

    // Raises an error if there are oversized arguments being passed
    if (!oversizedUsernames.isEmpty()) {
      hasErrors = true;
      log.error("There was oversized usernames in the list - more than maximum 25 characters");
      throw new IllegalArgumentException(
          "ERROR: These arguments must have a maximum length of 25 characters: "
              + oversizedUsernames);
    }

    return hasErrors;
  }
}
