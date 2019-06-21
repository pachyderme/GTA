package com.applications;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.applications.commands.AddTaskCommand;
import com.applications.commands.AddTimeToTaskCommand;
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
 * Command manager class.
 * @author GTA
 *
 */
public class CommandsManager {

    private transient List<Command> commands;
    private transient ExitCommand exitCommand;
    private transient User loggedUser;
    
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
        commands.add(new AddTimeToTaskCommand(loggedUser));
        commands.add(new HistoryCommand(loggedUser));
        commands.add(exitCommand);
    }
    
    /**
     * Handle the user's commands.
     * 
     * @param usersManager
     * @param tasksManager
     */
    public void handleCommands() {
        String commandName;
        showCommands();
        
        do {
            Utils.displayMessage(" > ");
            commandName = Utils.getUserResponse();
            
            Command matchedCommand = getCommand(commandName);
            matchedCommand.execute();
            
            if (Utils.isInTest()) {
                commandName = exitCommand.getName();
            }
        }
        while (!exitCommand.getName().equals(commandName));
    }
    
    private Command getCommand(String commandName) {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command command = iterator.next();
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
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command command = iterator.next();
            Utils.displayMessage(" - " + command.getName() + ": " + command.getDescription());
        }
        Utils.displayMessage("");
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public ExitCommand getExitCommand() {
        return exitCommand;
    }

    public void setExitCommand(ExitCommand exitCommand) {
        this.exitCommand = exitCommand;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
