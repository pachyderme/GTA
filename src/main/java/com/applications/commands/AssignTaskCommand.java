package com.applications.commands;

import java.util.ArrayList;

import com.applications.Task;
import com.applications.TasksManager;
import com.applications.User;
import com.applications.Utils;


/**
 * Assign task Command class.
 * @author GTA
 *
 */
public class AssignTaskCommand extends Command {

    public AssignTaskCommand(User loggedUser) {
        super(loggedUser);

        name = "assigntask";
        description = "Assignation à une tâche.";
    }
    
    public void execute() {
        ShowTasksCommand showTasksCommand = new ShowTasksCommand(loggedUser);
        TasksManager tasksManager = new TasksManager();
        
        showTasksCommand.action();
        Utils.displayMessage("ID de la tâche : ");
        String str = Utils.getUserResponse();
        ArrayList<Task> tasks = tasksManager.getTasksFromFile();
        try {
            int id = Integer.parseInt(str);
            Task task = tasksManager.getTask(tasks, id);
            
            if (task != null) {
                task.assignedUser = loggedUser.name;
                tasksManager.saveTasksInFile(tasks);
                Utils.displayMessage("Tâche assignée.");
            } else {
                Utils.displayMessage("Cette tâche n'existe pas.");
            }
        } catch (NumberFormatException e) {
            Utils.displayMessage(str + " n'est pas une valeur correcte.");
        }
    }

    
}
