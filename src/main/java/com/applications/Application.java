package com.applications;

public class Application {
    private static UsersManager usersManager;

    public static void main(String[] args) {
        usersManager = new UsersManager();
        usersManager.getUserAccount();
        Utils.handleCommands(usersManager);
    }
}
