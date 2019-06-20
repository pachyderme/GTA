package com.applications;

public class Application {
    private static UsersManager usersManager;
    private static TasksManager tasksManager;

    public static void main(String[] args) {
        usersManager = new UsersManager();
        usersManager.getUserAccount();
        Utils.handleCommands(usersManager, tasksManager);
    }
}
