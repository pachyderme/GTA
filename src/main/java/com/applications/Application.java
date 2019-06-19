package com.applications;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello World !");
		System.out.println("Saisissez votre nom :");
        String name = System.console().readLine();
        User connectedUser = connection(name);
        if(connectedUser != null) {
        	System.out.println("Bienvenue "+ name);
        }
	}
	
	public static User connection(String name) {
		return new User(name);
	}
	
}
