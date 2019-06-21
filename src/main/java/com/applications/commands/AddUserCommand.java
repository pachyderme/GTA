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
     * @param loggedTask
     */
    public AddUserCommand(User loggedUser) {
        super(loggedUser);

        setName("adduser");
        setDescription("Création d'un utilisateur.");
    }
    
    /**
     * Action executed.
     */
    public void action() {
        Utils.displayMessage("Nom de l'utilisateur : ");
        UsersManager usersManager = new UsersManager();
        String userName = Utils.getUserResponse();        
        usersManager.createUser(userName);
        Utils.displayMessage("Utilisateur créé.");
    }
}
