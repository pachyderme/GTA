package com.applications.commands;

import com.applications.TasksManager;
import com.applications.Utils;

public class AddTaskCommand extends Command {
    /**
     * Constructor.
     */
    public AddTaskCommand() {
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
