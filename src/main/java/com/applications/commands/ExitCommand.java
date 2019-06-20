package com.applications.commands;

import com.applications.Utils;

public class ExitCommand extends Command {
    /**
     * Constructor.
     */
    public ExitCommand() {
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
