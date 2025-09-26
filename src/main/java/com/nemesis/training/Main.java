package com.nemesis.training;

import java.sql.SQLException;

public class Main {

    private static final String CONFIG_FILE = "config.file";
    private static final String DB_CONNECTION_FILE = "application.properties";

    public static int run(String[] args) {
        try {
            System.setProperty(CONFIG_FILE, DB_CONNECTION_FILE);
            new UserCommand().run(args);
            return 0;
        } catch (ConfigFileException e) {
            System.err.println("Config file problem: " + e.getMessage());
            return 1;
        } catch (SQLException e) {
            System.err.println("Database problem: " + e.getMessage());
            return 2;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Input/Validation problem: " + e.getMessage());
            return 3;
        }
    }

    public static void main(String[] args) {
        int status = run(args);
        System.exit(status);
    }
}