package com.applications.commands;

import com.applications.User;
import com.applications.UsersManager;
import com.applications.Utils;

/**
 * Add User Command class.
 * @author GTA
 *
 */
public class AddUserCommand extends Command {
    /**
     * Constructor.
     */
    public AddUserCommand(User loggedUser) {
        super(loggedUser);

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
