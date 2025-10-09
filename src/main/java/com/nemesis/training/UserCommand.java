package com.nemesis.training;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserCommand {

  public void run(String[] args) throws SQLException, ConfigFileException {
    List<String> usernames = Arrays.asList(args);

    if (UsernameValidator.isUsernameInvalid(usernames)) {
      log.error("Username list is not valid - invalid usernames were provided");
      return;
    }

    log.debug("Connecting to the repository");
    UserRepository repo = new UserRepository();
    repo.connect();

    for (String username : usernames) {
      log.trace("Adding username: {}", username);
      User user = new User(username);
      Long id = repo.save(user);
      // System.out.println("Username added: " + username + " (ID: " + id + ")");
      log.info("Username: {} added with ID: {}", username, id);
    }
  }
}
