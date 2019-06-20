package com.applications.commands;

import com.applications.Utils;

public class UnknownCommand extends Command {
    /**
     * Constructor.
     */
    public UnknownCommand(String name) {
        this.name = name;
        this.description = "Commande inconnue.";
        
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();

        Utils.displayMessage(
                "Commande inconnue. Tapez \"help\"" +
                " pour voir la liste des commandes disponibles.");
    }
}
