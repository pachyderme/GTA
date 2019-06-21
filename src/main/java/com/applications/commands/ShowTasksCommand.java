package com.applications.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.applications.Task;
import com.applications.TasksManager;
import com.applications.User;
import com.applications.Utils;

/**
 * Show Tasks Command class.
 * @author GTA
 *
 */
public class ShowTasksCommand extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public ShowTasksCommand(User loggedTask) {
        super(loggedTask);
        
        name = "showtasks";
        description = "Affichage de la liste des tâches.";
    }

    /**
     * Action executed.
     */
    public void action() {
        TasksManager usersManager = new TasksManager();
        ArrayList<Task> tasks = usersManager.getTasksFromFile();
        Utils.displayMessage("Liste des tâches :");

        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            Utils.displayMessage(" - " + task.id + ". " + task.name + 
                    ", assignée à " + task.assignedUser + " (" + task.time + "h)");
        }
    }

}
