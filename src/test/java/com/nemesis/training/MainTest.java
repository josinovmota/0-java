package com.nemesis.training;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

class MainTest {

  @Test
  void mustReturn0WhenAllIsFine() {
    String[] args = {"josinobereteu", "guilhermepapao"};
    int status = Main.run(args);
    assertEquals(0, status);
  }

  @Test
  void mustReturn1WhenConfigFileFails() {
    try (MockedStatic<ConfigLoader> mocked = mockStatic(ConfigLoader.class)) {
      mocked
          .when(ConfigLoader::loadSystemPropertyAndLoad)
          .thenThrow(new ConfigFileException("mocked"));
      int status = Main.run(new String[] {"validusername"});
      assertEquals(1, status);
    }
  }

  @Test
  void mustReturn2WhenDatabaseFails() {
    try (MockedConstruction<UserRepository> mocked =
        mockConstruction(
            UserRepository.class,
            (mock, context) -> doThrow(new SQLException("db error")).when(mock).connect())) {
      int status = Main.run(new String[] {"validusername"});
      assertEquals(2, status);
    }
  }

  @Test
  void mustReturn3WhenInvalidUsername() {
    String[] args = {"ANA"};
    int status = Main.run(args);
    assertEquals(3, status);
  }

  @Test
  void mustExitWithSameStatusFromMainWhenMainMethodIsCalled() throws Exception {
    int status = catchSystemExit(() -> Main.main(new String[] {"ANA"}));
    assertEquals(3, status);
  }
}
