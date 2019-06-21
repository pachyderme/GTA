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
     * @param loggedTask
     */
    public HelpCommand(User loggedUser) {
        super(loggedUser);
        
        name = "help";
        description = "Affichage de la liste des commandes disponibles.";
    }

    /**
     * Action executed.
     */
    public void action() {
        CommandsManager commandsManager = new CommandsManager(this.loggedUser);
        commandsManager.showCommands();
    }

}
