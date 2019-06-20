package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Utils class.
 * 
 * @author GTA
 */
public class Utils {
    static boolean inTest = false;
    static String responseSubstitute = "";

    /**
     * Get the user response from command line.
     * 
     * @return
     */
    static String getUserResponse() {

        if (!inTest) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                return br.readLine().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return responseSubstitute;
        }

        return null;
    }

    /**
     * Display a message to the output.
     * 
     * @param message
     */
    static void displayMessage(String message) {
        if (!inTest) {
            System.out.println(message);
        } else {
            logMessage("en test");
        }
    }

    /**
     * Log a message.
     * 
     * @param message
     */
    static void logMessage(String message) {

    }

    /**
     * Handle the user's commands.
     * 
     * @param usersManager
     * @param tasksManager
     */
    static void handleCommands(UsersManager usersManager, TasksManager tasksManager, User user) {
        String choice = null;
        showCommands();

        while (!"exit".equals(choice)) {
            displayMessage(" > ");
            choice = Utils.getUserResponse();
            switch (choice) {
            case "help":
                showCommands();
                break;
            case "adduser":
                displayMessage("Nom de l'utilisateur : ");
                String userName = Utils.getUserResponse();
                usersManager.createUser(userName);
                displayMessage("Utilisateur créé.");
                break;
            case "addtask":
                displayMessage("Nom de la tâche : ");
                String taskName = Utils.getUserResponse();
                tasksManager.createTask(taskName);
                displayMessage("Tâche créée.");
                break;
            case "showusers":
                showUsers(usersManager);
                break;
            case "showtasks":
                showTasks(tasksManager);
                break;
            case "assigntask":
                showTasks(tasksManager);
                displayMessage("ID de la tâche : ");
                String taskId = Utils.getUserResponse();
                try {
                    Task task = new Task(Integer.parseInt(taskId), "");
                    if (tasksManager.taskExists(task)) {
                        ArrayList<Task> tasks = tasksManager.getTasksFromFile();
                        Iterator<Task> it = tasks.iterator();
                        while (it.hasNext()) {
                            Task tmpTask = it.next();
                            if (tmpTask.id == task.id) {
                                tmpTask.assignedUser = user.name;
                            }
                        }

                        tasksManager.saveTasksInFile(tasks);
                        displayMessage("Tâche assignée.");
                    }
                } catch (NumberFormatException e) {
                    displayMessage(taskId + " n'est pas une valeur correcte.");
                }

                break;
            case "exit":
                displayMessage("Deconnexion.");
                break;
            default:
                displayMessage("Commande inconnue. Tapez \"help\"" 
            + " pour voir la liste des commandes disponibles.");
                break;
            }

            if (inTest) {
                choice = "exit";
            }
        }
    }

    /**
     * Show the commands list.
     */
    private static void showCommands() {
        displayMessage("Commandes disponibles :");
        displayMessage(" - help: Affichage de la liste des commandes disponibles.");
        displayMessage(" - adduser: Création d'un utilisateur.");
        displayMessage(" - addtask: Création d'une tâche.");
        displayMessage(" - assigntask: Affectation d'une tâche.");
        displayMessage(" - showusers: Liste les utilisateurs.");
        displayMessage(" - showtasks: Liste les tâches.");
        displayMessage(" - exit: Fermeture de l'application.");
        displayMessage("");
    }

    /**
     * Display the user list
     * 
     * @param usersManager
     */
    private static void showUsers(UsersManager usersManager) {
        ArrayList<String> users = usersManager.getUsersFromFile();
        displayMessage("Liste des utilisateurs :");
        Iterator<String> it = users.iterator();
        while (it.hasNext()) {
            displayMessage(" - " + it.next());
        }
    }

    /**
     * Display the tasks list
     * 
     * @param tasksManager
     */
    private static void showTasks(TasksManager tasksManager) {
        ArrayList<Task> tasks = tasksManager.getTasksFromFile();
        displayMessage("Liste des tâches :");
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            displayMessage(" - " + task.id + " " + task.name + " " + task.assignedUser);
        }
    }
}
