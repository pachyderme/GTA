package com.applications.commands;

import java.util.Iterator;
import java.util.List;

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
        
        setName("showtasks");
        setDescription("Affichage de la liste des tâches.");
    }

    /**
     * Action executed.
     */
    public void action() {
        TasksManager usersManager = new TasksManager();
        List<Task> tasks = usersManager.getTasksFromFile();
        Utils.displayMessage("Liste des tâches :");

        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            Utils.displayMessage(" - " + task.getId() + ". " + task.getName() 
                + ", assignée à " + task.getAssignedUser() + " (" + task.getTime() + "h)");
        }
    }

}
