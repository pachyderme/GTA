package com.applications.commands;

import com.applications.User;
import com.applications.Utils;

/**
 * Unknown Command class.
 * @author GTA
 *
 */
public class UnknownCommand extends Command {
    /**
     * Constructor.
     */
    public UnknownCommand(User loggedUser, String name) {
        super(loggedUser);
        
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
