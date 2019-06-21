package com.applications;

/**
 * Application class.
 * 
 * @author GTA
 */
public class Application {
    private static UsersManager usersManager;

    /**
     * Start the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        usersManager = new UsersManager();
        do {
            User loggedUser = usersManager.getUserAccount();
            
            CommandsManager commandsManager = new CommandsManager(loggedUser);
            commandsManager.handleCommands();
        } while(true);
    }
}
