package com.applications.commands;

import com.applications.TasksManager;
import com.applications.User;
import com.applications.Utils;

/**
 * Add Task Command class.
 * @author GTA
 *
 */
public class AddTaskCommand extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public AddTaskCommand(User loggedUser) {
        super(loggedUser);
        
        name = "addtask";
        description = "Création d'une tâche.";
    }
    
    /**
     * Action executed.
     */
    public void action() {
        Utils.displayMessage("Nom de la tâche : ");
        TasksManager tasksManager = new TasksManager();
        String taskName = Utils.getUserResponse();        
        tasksManager.createTask(taskName);
        Utils.displayMessage("Tâche créée.");
    }
}
