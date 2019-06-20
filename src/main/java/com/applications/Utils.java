package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utils class
 * @author GTA
 */
public class Utils {
    static boolean inTest = false;
    static String userSubstitute = "";
    
    /**
     * Get the user response from command line
     * @return
     */
    static String getUserResponse() {

        if (!inTest) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return userSubstitute;
        }

        return null;
    }

    /**
     * Display a message to the output
     * @param message
     */
    static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Log a message
     * @param message
     */
    static void logMessage(String message) {

    }

    /**
     * Handle the user's commands
     * @param usersManager
     */
    static void handleCommands(UsersManager usersManager) {
        String choice = null;

        while (!"exit".equals(choice)) {
            System.out.println(" > ");
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
            case "exit":
                displayMessage("Fermeture de l'application.");
                break;
            default:
                displayMessage("Commande inconnue. Tapez \"help\""
                        + " pour voir la liste des commandes disponibles.");
                break;
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
        displayMessage(" - exit: Fermeture de l'application.");
        displayMessage("");
    }
}
