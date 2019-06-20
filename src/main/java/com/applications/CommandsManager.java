package com.applications;

import java.util.ArrayList;

import com.applications.commands.AddTaskCommand;
import com.applications.commands.AddUserCommand;
import com.applications.commands.Command;
import com.applications.commands.ExitCommand;
import com.applications.commands.HelpCommand;
import com.applications.commands.UnknownCommand;

/**
 * Command class.
 * @author GTA
 *
 */
public class CommandsManager {

    protected ArrayList<Command> commands;
    protected ExitCommand exitCommand;
    protected User loggedUser;
    
    public CommandsManager(User loggedUser) {
        this.loggedUser = loggedUser;
        
        commands = new ArrayList<Command>();
        exitCommand = new ExitCommand(loggedUser);

        commands.add(new HelpCommand(loggedUser));
        commands.add(new AddUserCommand(loggedUser));
        commands.add(new AddTaskCommand(loggedUser));
        commands.add(exitCommand);
    }
    
    /**
     * Handle the user's commands.
     * 
     * @param usersManager
     * @param tasksManager
     */
    public void handleCommands(UsersManager usersManager, TasksManager tasksManager) {
        String commandName = null;
        showCommands();
        

        while (!exitCommand.getName().equals(commandName)) {
            Utils.displayMessage(" > ");
            commandName = Utils.getUserResponse();
            
            Command matchedCommand = null;
            for (Command command : commands) {
                if (commandName.equals(command.getName())) {
                    matchedCommand = command;
                }
            }
            
            if (matchedCommand == null) {
                matchedCommand = new UnknownCommand(loggedUser, commandName);
            }
            matchedCommand.execute();
            
            if (Utils.inTest) {
                commandName = exitCommand.getName();
            }
        }
    }

    /**
     * Show the commands list.
     */
    public void showCommands() {
        Utils.displayMessage("Commandes disponibles :");
        for (Command command : commands) {
            Utils.displayMessage(" - " + command.getName() + ": " + command.getDescription());
        }
        Utils.displayMessage("");
    }
}
