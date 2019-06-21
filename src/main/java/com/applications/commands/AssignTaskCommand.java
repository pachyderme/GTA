package com.applications.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.applications.Task;
import com.applications.TasksManager;
import com.applications.User;
import com.applications.Utils;

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
        String taskId = Utils.getUserResponse();
        try {
            Task task = new Task(Integer.parseInt(taskId), "");
            if (tasksManager.taskExists(task)) {
                ArrayList<Task> tasks = tasksManager.getTasksFromFile();
                Iterator<Task> it = tasks.iterator();
                while (it.hasNext()) {
                    Task tmpTask = it.next();
                    if (tmpTask.id == task.id) {
                        tmpTask.assignedUser = loggedUser.name;
                    }
                }

                tasksManager.saveTasksInFile(tasks);
                Utils.displayMessage("Tâche assignée.");
            }
        } catch (NumberFormatException e) {
            Utils.displayMessage(taskId + " n'est pas une valeur correcte.");
        }
    }

}
