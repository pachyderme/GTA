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
			System.out.println(" > ");
			choice = askString();
			switch (choice) {
				case "adduser":
					System.out.println("Nom de l'utilisateur : ");
					String name = askString();
					usersManager.createUser(name);
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
