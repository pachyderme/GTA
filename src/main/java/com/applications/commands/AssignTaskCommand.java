package com.applications.commands;

import java.util.List;

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
    /**
     * Constructor.
     * @param loggedTask
     */
    public AssignTaskCommand(User loggedUser) {
        super(loggedUser);

        name = "assigntask";
        description = "Assignation à une tâche.";
    }
    
    /**
     * Action executed.
     */
    public void action() {
        ShowTasksCommand showTasksCommand = new ShowTasksCommand(loggedUser);
        TasksManager tasksManager = new TasksManager();
        
        showTasksCommand.action();
        Utils.displayMessage("ID de la tâche : ");
        String str = Utils.getUserResponse();
        List<Task> tasks = tasksManager.getTasksFromFile();
        try {
            int id = Integer.parseInt(str);
            Task task = tasksManager.getTask(tasks, id);
            
            if (task != null) {
                task.setAssignedUser(loggedUser.getName());
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
