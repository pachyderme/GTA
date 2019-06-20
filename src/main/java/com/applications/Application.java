package com.applications;

/**
 * Application class
 * @author GTA
 */
public class Application {
    private static UsersManager usersManager;
    private static TasksManager tasksManager;

    /**
     * Start the application
     * @param args
     */
    public static void main(String[] args) {
        usersManager = new UsersManager();
        usersManager.getUserAccount();
        Utils.handleCommands(usersManager, tasksManager);
    }
}
