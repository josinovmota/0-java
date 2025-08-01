package com.nemesis.training;

import picocli.CommandLine;

public class Main {

  private static final String CONFIG_FILE = "config.file";
  private static final String DB_CONNECTION_FILE = "application.properties";

  public static void main(String[] args) {
    System.setProperty(CONFIG_FILE, DB_CONNECTION_FILE);
    int exitCode = new CommandLine(new UserCommand()).execute(args);
  }
}
