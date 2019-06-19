package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    
    static String getUserResponse() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return str;        
    }
    
    static void displayMessage(String message) {
        System.out.println(message);        
    }
    
    static void logMessage(String message) {
                
    }
    
    static void handleCommands(UsersManager usersManager) {
        String choice = null;

        while (!"exit".equals(choice)) {
            System.out.println(" > ");
            choice = Utils.getUserResponse();
            switch (choice) {
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
                    displayMessage("Commande inconnue");
            }
        }
    } 
}
