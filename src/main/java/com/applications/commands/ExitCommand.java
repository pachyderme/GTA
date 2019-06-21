package com.applications.commands;

import com.applications.User;
import com.applications.Utils;

/**
 * Exit Command class.
 * @author GTA
 *
 */
public class ExitCommand extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public ExitCommand(User loggedUser) {
        super(loggedUser);
        
        name = "exit";
        description = "Fermeture du programme.";
    }

    /**
     * Action executed.
     */
    public void action() {
        Utils.displayMessage("Fermeture du programme.");
    }
}
