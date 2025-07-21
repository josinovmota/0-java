package com.nemesis.training;

import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(name = "app", description = "Receive arguments and print them")
public class UserCommand implements Runnable {

    @CommandLine.Parameters
    List<String> usernames;

    public void run() {
        UsernameValidator validator = new UsernameValidator();
        validator.usernames = usernames;

        boolean hasErrors = validator.validate();

        if (hasErrors) {
            return;
        }

        try {
            UserRepository repo = new UserRepository();

            for (String username : usernames) {
                User user = new User(username);
                Long id = repo.save(user);
                System.out.println("User added: " + username + " (ID: " + id + ")");
            }

        } catch (Exception e) {
            System.out.println("ERROR: Got an error saving user in the database: " + e.getMessage());
        }
    }
}