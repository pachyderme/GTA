package com.applications.commands;

import com.applications.UsersManager;
import com.applications.Utils;

public class AddUserCommand extends Command {
    /**
     * Constructor.
     */
    public AddUserCommand() {
        name = "adduser";
        description = "Création d'un utilisateur.";
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();
        
        Utils.displayMessage("Nom de l'utilisateur : ");
        UsersManager usersManager = new UsersManager();
        String userName = Utils.getUserResponse();        
        usersManager.createUser(userName);
        Utils.displayMessage("Utilisateur créé.");
    }
}
