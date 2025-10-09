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

    log.info("Connecting to the repository");
    UserRepository repo = new UserRepository();
    repo.connect();
    log.info("Successful connection to the Repository");

    for (String username : usernames) {
      log.info("Adding username: {}", username);
      User user = new User(username);
      Long id = repo.save(user);
      log.info("Username added: {} ID: {}", username, id);
    }
  }
}
