package com.nemesis.training;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        // TODO: Add createTableIfNotExists
        System.setProperty("config.file", "application.properties");

        int exitCode = new CommandLine(new UserCommand()).execute(args);
    }
}
