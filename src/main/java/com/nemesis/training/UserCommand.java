package com.nemesis.training;

import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "app", description = "Receive arguments and print them")
public class UserCommand implements Runnable {

    @CommandLine.Parameters
    List<String> usernames;

    public void run() {
        // Checks if no arguments were provided
        if (usernames == null || usernames.isEmpty()) {
            System.err.println("ERROR: At least one argument must be passed");
            return;
        }

        // Creates validation lists
        List<String> notAlphabetic = new ArrayList<>();
        List<String> notLowerCase = new ArrayList<>();
        List<String> undersizedUsernames = new ArrayList<>();
        List<String> oversizedUsernames = new ArrayList<>();

        // Constraints
        int argumentMinimumLength = 8;
        int argumentMaximumLength = 25;

        // Checks if arguments are according to the constraints and add wrong ones to validation lists
        for (String username : usernames) {
            // Checks if the arguments are alphabetic string ( i )
            if (!username.matches("[a-zA-Z]+")) {
                notAlphabetic.add(username);
            // Checks if the arguments are in lower-case ( i )
            } else if (!username.matches("[a-z]+")) {
                notLowerCase.add(username);
            // Checks if the arguments have a minimum length of 8 characters
            } else if (username.length() < argumentMinimumLength) {
                undersizedUsernames.add(username);
                // Checks if the arguments have a maximum length of 8 characters
            } else if (username.length() > argumentMaximumLength) {
                oversizedUsernames.add(username);
            }
        }

        // Validation variable to look for errors
        boolean hasErrors = false;

        // Raises an error if there are non-alphabetic arguments being passed
        if (!notAlphabetic.isEmpty()) {
            System.err.println("ERROR: These arguments are not alphabetic: " + notAlphabetic);
            hasErrors = true;
        }

        // Raises an error if there are non-lowercase arguments being passed
        if (!notLowerCase.isEmpty()) {
            System.err.println("ERROR: These arguments must be lowercase: " + notLowerCase);
            hasErrors = true;
        }

        // Raises an error if there are undersized arguments being passed
        if (!undersizedUsernames.isEmpty()) {
            System.err.println("ERROR: These arguments must have a minimum length of 8 characters: " + undersizedUsernames);
            hasErrors = true;
        }

        // Raises an error if there are oversized arguments being passed
        if (!oversizedUsernames.isEmpty()) {
            System.err.println("ERROR: These arguments must have a maximum length of 25 characters: " + oversizedUsernames);
            hasErrors = true;
        }

        // If validations got errors, the program stops
        if (hasErrors) {
            return;
        }

        try {
            UserRepository repo = new UserRepository();

            for (String username : usernames) {
                User user = new User(username);
                long id = repo.save(user);
                System.out.println("User added: " + username + " (ID: " + id + ")");
            }

        } catch (Exception e) {
            System.out.println("ERROR: Got an error saving user in the database: " + e.getMessage());
        }

    }
}