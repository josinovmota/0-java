package com.nemesis.training;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserCommand {

  public void run(String[] args) throws SQLException, ConfigFileException {
    List<String> usernames = Arrays.asList(args);

    if (UsernameValidator.isUsernameInvalid(usernames)) {
      return;
    }

    UserRepository repo = new UserRepository();
    repo.connect();

    for (String username : usernames) {
      User user = new User(username);
      Long id = repo.save(user);
      System.out.println("Username added: " + username + " (ID: " + id + ")");
    }
  }
}
