package com.applications.commands;

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
public class AddTimeToTaskCommand  extends Command {
    /**
     * Constructor.
     * @param loggedTask
     */
    public AddTimeToTaskCommand(User loggedTask) {
        super(loggedTask);
        
        setName("addtime");
        setDescription("Ajoute du temps à une tâche.");
    }
    
    /**
     * Action executed.
     */
    public void action() {
        ShowTasksCommand showTasksCommand = new ShowTasksCommand(getLoggedUser());
        TasksManager tasksManager = new TasksManager();
        
        showTasksCommand.action();
        Utils.displayMessage("ID de la tâche : ");
        String str = Utils.getUserResponse();
        List<Task> tasks = tasksManager.getTasksFromFile();
        try {
            int id = Integer.parseInt(str);
            Task task = tasksManager.getTask(tasks, id);
            
            if (task != null) {
                Utils.displayMessage("Temps (en heures): ");
                str = Utils.getUserResponse();
                try {
                    int time = Integer.parseInt(str);
                    
                    task.setTime(task.getTime() + time);
                    tasksManager.saveTasksInFile(tasks);
                    Utils.displayMessage("Temps ajouté à la tâche. Temps total: "
                            + task.getTime() + "h.");
                } catch (NumberFormatException e) {
                    Utils.displayMessage(str + " n'est pas une valeur correcte.");
                }
            } else {
                Utils.displayMessage("Cette tâche n'existe pas.");
            }
        } catch (NumberFormatException e) {
            Utils.displayMessage(str + " n'est pas une valeur correcte.");
        }
    }
}
