package com.applications.commands;

import com.applications.CommandsManager;

public class HelpCommand extends Command {
    /**
     * Constructor.
     */
    public HelpCommand() {
        name = "help";
        description = "Affichage de la liste des commandes disponibles.";
        
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();
        
        CommandsManager commandsManager = new CommandsManager();
        commandsManager.showCommands();
    }

}
