package com.applications;

import java.util.ArrayList;
import java.util.Iterator;

import com.applications.commands.AddTaskCommand;
import com.applications.commands.AddUserCommand;
import com.applications.commands.Command;
import com.applications.commands.ExitCommand;
import com.applications.commands.HelpCommand;
import com.applications.commands.HistoryCommand;
import com.applications.commands.AssignTaskCommand;
import com.applications.commands.ShowTasksCommand;
import com.applications.commands.ShowUsersCommand;
import com.applications.commands.UnknownCommand;

/**
 * Command class.
 * @author GTA
 *
 */
public class CommandsManager {

    protected transient ArrayList<Command> commands;
    protected transient ExitCommand exitCommand;
    protected transient User loggedUser;
    
    public CommandsManager(User loggedUser) {
        this.loggedUser = loggedUser;
        
        commands = new ArrayList<Command>();
        exitCommand = new ExitCommand(loggedUser);

        commands.add(new HelpCommand(loggedUser));
        commands.add(new AddUserCommand(loggedUser));
        commands.add(new AddTaskCommand(loggedUser));
        commands.add(new ShowUsersCommand(loggedUser));
        commands.add(new ShowTasksCommand(loggedUser));
        commands.add(new AssignTaskCommand(loggedUser));
        commands.add(new HistoryCommand(loggedUser));
        commands.add(exitCommand);
    }
    
    /**
     * Handle the user's commands.
     * 
     * @param usersManager
     * @param tasksManager
     */
    public void handleCommands(UsersManager usersManager, TasksManager tasksManager) {
        String commandName;
        showCommands();
        
        do {
            Utils.displayMessage(" > ");
            commandName = Utils.getUserResponse();
            
            Command matchedCommand = getCommand(commandName);
            matchedCommand.execute();
            
            if (Utils.inTest) {
                commandName = exitCommand.getName();
            }
        }
        while (!exitCommand.getName().equals(commandName));
    }
    
    private Command getCommand(String commandName) {
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            Command command = it.next();
            if (commandName.equals(command.getName())) {
                return command;
            }
        }
        
        return new UnknownCommand(loggedUser, commandName);
    }

    /**
     * Show the commands list.
     */
    public void showCommands() {
        Utils.displayMessage("Commandes disponibles :");
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            Command command = it.next();
            Utils.displayMessage(" - " + command.getName() + ": " + command.getDescription());
        }
        Utils.displayMessage("");
    }
}
