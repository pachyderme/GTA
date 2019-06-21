package com.applications.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.applications.LogsManager;
import com.applications.User;
import com.applications.Utils;

/**
 * History Command class.
 * @author GTA
 *
 */
public class HistoryCommand extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public HistoryCommand(User loggedUser) {
        super(loggedUser);
        
        name = "history";
        description = "Affichage de la liste de l'historique des commandes éxécutées.";
    }

    /**
     * Action executed.
     */
    public void action() {
        LogsManager logsManager = new LogsManager(loggedUser);
        ArrayList<String> logs = logsManager.getLogsFromFile();
        
        Utils.displayMessage("Historique des commandes :");

        Iterator<String> it = logs.iterator();
        while (it.hasNext()) {
            Utils.displayMessage(" - " + it.next());
        }
    }

}
