package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static UsersManager usersManager;
    private static TasksManager tasksManager;

    public static void main(String[] args) {
        usersManager = new UsersManager();
        tasksManager = new TasksManager();
        
        connection();
        handleCommands();
    }

    public static void connection() {
        usersManager.createAdminIfNotExists();

        String userName = "";
        User user = null;
        boolean knownUser = false;
        while (!knownUser) {
            System.out.println("Saisissez votre nom :");
            userName = askString();

            user = new User(userName);
            knownUser = usersManager.userExists(user);

            if (!knownUser) {
                System.out.println("Utilisateur incconu");
            }
        }

        System.out.println("Bienvenue " + userName);
    }

    private static void handleCommands() {
        String choice = null;
        showCommands();
        
        while (!"exit".equals(choice)) {
            System.out.println(" > ");
            choice = askString();
            switch (choice) {
            case "help":
                showCommands();
                break;
            case "adduser":
                System.out.println("Nom de l'utilisateur : ");
                String userName = askString();
                usersManager.createUser(userName);
                System.out.println("Utilisateur créé.");
                break;
            case "addtask":
                System.out.println("Nom de la tâche : ");
                String taskName = askString();
                tasksManager.createTask(taskName);
                System.out.println("Tâche créée.");
                break;
            case "exit":
                System.out.println("Fermeture de l'application.");
                break;
            default:
                System.out.println("Commande inconnue. Tapez \"help\" pour voir la liste des commandes disponibles.");
            }
        }
    }
    
    /**
     * Show the commands list.
     */
    private static void showCommands() {
        System.out.println("Commandes disponibles :");
        System.out.println(" - help: Affichage de la liste des commandes disponibles.");
        System.out.println(" - adduser: Création d'un utilisateur.");
        System.out.println(" - exit: Fermeture de l'application.");
        System.out.println("");
    }

    private static String askString() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
