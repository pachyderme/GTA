package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
	private static UsersManager usersManager;

	public static void main(String[] args) {
		connection();
    	handleCommands();
	}
	
	public static void connection() {
		usersManager = new UsersManager();
		usersManager.createAdminIfNotExists();
				
		String userName = "";
		User user = null;
		boolean knownUser = false;
		while(!knownUser) {
			System.out.println("Saisissez votre nom :");
	        userName = askString();
	        
	        user = new User(userName);
	        knownUser = usersManager.userExists(user);
	        
	        if(!knownUser) {
	    		System.out.println("Utilisateur incconu");
	        }
		}

    	System.out.println("Bienvenue "+ userName);
	}
	
	private static void handleCommands() {
		String choice = null;

		while (!"exit".equals(choice)) {
			System.out.println(" > ");
			choice = askString();
			switch (choice) {
				case "adduser":
					System.out.println("Nom de l'utilisateur : ");
					String userName = askString();
					usersManager.createUser(userName);
					System.out.println("Utilisateur créé.");
					break;
				case "exit":
					System.out.println("Fermeture de l'application.");
					break;
				default:
					System.out.println("Commande inconnue");
			}
		}
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
