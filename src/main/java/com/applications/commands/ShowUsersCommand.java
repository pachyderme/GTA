package com.applications.commands;

import java.util.Iterator;
import java.util.List;

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
        
        setName("showusers");
        setDescription("Affichage de la liste des utilisateurs.");
    }

    /**
     * Action executed.
     */
    public void action() {
        UsersManager usersManager = new UsersManager();
        List<String> users = usersManager.getUsersFromFile();
        Utils.displayMessage("Liste des utilisateurs :");

        Iterator<String> it = users.iterator();
        while (it.hasNext()) {
            Utils.displayMessage(" - " + it.next());
        }
    }

}
