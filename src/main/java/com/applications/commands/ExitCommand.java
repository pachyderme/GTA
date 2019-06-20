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
     */
    public ExitCommand(User loggedUser) {
        super(loggedUser);
        
        name = "exit";
        description = "Fermeture du programme.";
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();
        
        Utils.displayMessage("Fermeture du programme.");
    }
}
