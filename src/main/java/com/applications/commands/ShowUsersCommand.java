package com.applications.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.applications.User;
import com.applications.UsersManager;
import com.applications.Utils;

/**
 * Show Users Command class.
 * @author GTA
 *
 */
public class ShowUsersCommand extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public ShowUsersCommand(User loggedUser) {
        super(loggedUser);
        
        name = "showusers";
        description = "Affichage de la liste des utilisateurs.";
    }

    /**
     * Action executed.
     */
    public void action() {
        UsersManager usersManager = new UsersManager();
        ArrayList<String> users = usersManager.getUsersFromFile();
        Utils.displayMessage("Liste des utilisateurs :");

        Iterator<String> it = users.iterator();
        while (it.hasNext()) {
            Utils.displayMessage(" - " + it.next());
        }
    }

}
