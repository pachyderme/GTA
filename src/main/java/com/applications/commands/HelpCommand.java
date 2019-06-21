package com.applications.commands;

import com.applications.CommandsManager;
import com.applications.User;

/**
 * Help Command class.
 * @author GTA
 *
 */
public class HelpCommand extends Command {
    /**
     * Constructor.
     */
    public HelpCommand(User loggedUser) {
        super(loggedUser);
        
        name = "help";
        description = "Affichage de la liste des commandes disponibles.";
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();
        
        CommandsManager commandsManager = new CommandsManager(this.loggedUser);
        commandsManager.showCommands();
    }

}
