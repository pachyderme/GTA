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
     * @param loggedTask
     */
    public UnknownCommand(User loggedUser, String name) {
        super(loggedUser);
        
        setName(name);
        setDescription("Commande inconnue.");
    }

    /**
     * Action executed.
     */
    public void action() {
        Utils.displayMessage(
                "Commande inconnue. Tapez \"help\"" 
                + " pour voir la liste des commandes disponibles.");
    }
}
