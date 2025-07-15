package com.nemesis.training;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new UserCommand()).execute(args);
    }
}
