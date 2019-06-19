package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

	public static void main(String[] args) {
		UsersManager usersManager = new UsersManager();

		usersManager.createAdminIfNotExists();
		String choice = null;
		
		while (!"exit".equals(choice)) {
			choice = askChoice();
			switch (choice) {
				case "adduser":
					System.out.println("Ajout d'un utilisateur.");
					break;
				case "exit":
					System.out.println("Fermeture de l'application.");
					break;
				default:
					System.out.println("Commande inconnue");
			}
		}
	}
	
	private static String askChoice() {
		System.out.println(" > ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choice = null;
		try {
			choice = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return choice;
	}
}
