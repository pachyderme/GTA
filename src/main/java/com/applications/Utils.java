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
    public static boolean inTest = false;
    public static String responseSubstitute = "";

    /**
     * Get the user response from command line.
     * 
     * @return
     */
    public static String getUserResponse() {

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
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Log a message.
     * 
     * @param message
     */
    public static void logMessage(String message) {
        System.out.println("[" + message + "]");
    }
    
    /**
     * Display the user list
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
     *  Display the tasks list
     * @param tasksManager
     */
    private static void showTasks(TasksManager tasksManager) {
        ArrayList<String> tasks = tasksManager.getTasksFromFile();
        displayMessage("Liste des tâches :");
        Iterator<String> it = tasks.iterator();
        while (it.hasNext()) {
            displayMessage(" - " + it.next());         
        }   
    }
}
