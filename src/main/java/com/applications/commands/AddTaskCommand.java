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
     */
    public AddTaskCommand(User loggedUser) {
        super(loggedUser);
        
        name = "addtask";
        description = "Création d'une tâche.";
    }

    /**
     * Execute the command.
     */
    public void execute() {
        super.execute();
        
        Utils.displayMessage("Nom de la tâche : ");
        TasksManager tasksManager = new TasksManager();
        String taskName = Utils.getUserResponse();        
        tasksManager.createTask(taskName);
        Utils.displayMessage("Tâche créée.");
    }
}
