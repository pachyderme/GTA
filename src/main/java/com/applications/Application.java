package com.applications;

public class Application {

	public static void main(String[] args) {
		UsersManager usersManager = new UsersManager();

		usersManager.createAdminIfNotExists();
	}
}
