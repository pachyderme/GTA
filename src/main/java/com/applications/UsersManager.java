package com.applications;

import java.util.ArrayList;

/**
 * User manager class.
 * 
 * @author GTA
 */
public class UsersManager {
    private static final String USERS_FILE_PATH = "data/users.csv";

    /**
     * Get the users from the users file.
     * 
     * @return
     */
    public ArrayList<String> getUsersFromFile() {
        return FilesManager.readFile(USERS_FILE_PATH);
    }

    /**
     * Check if the admin user exists.
     * 
     * @return
     */
    public boolean adminExists() {
        User user = new User("Admin");
        return userExists(user);
    }

    /**
     * Check if a user exists.
     * 
     * @param user
     * @return boolean
     */
    public boolean userExists(User user) {
        ArrayList<String> users = getUsersFromFile();
        return users.contains(user.name);
    }

    /**
     * Create the admin user if not exists.
     */
    public void createAdminIfNotExists() {
        if (!adminExists()) {
            ArrayList<String> users = getUsersFromFile();
            users.add("Admin");

            saveUsersInFile(users);
        } else {
            Utils.logMessage("L'administrateur existe déjà.");
        }
    }

    /**
     * Save the users in the users file.
     * 
     * @param users
     */
    public void saveUsersInFile(ArrayList<String> users) {
        FilesManager.saveItemsInFile(USERS_FILE_PATH, users);
    }

    /**
     * Delete the users file.
     * 
     * @return boolean
     */
    public boolean deleteUsersFile() {
        return FilesManager.deleteFile(USERS_FILE_PATH);
    }

    /**
     * Check if the users file exists.
     * 
     * @return boolean
     */
    public boolean usersFileExists() {
        return FilesManager.fileExists(USERS_FILE_PATH);
    }

    /**
     * Create user file if the users file not exists.
     */
    public void createUsersFileIsNotExists() {
        FilesManager.createFileIsNotExists(USERS_FILE_PATH);
    }

    /**
     * Create a user.
     * 
     * @param name
     */
    public void createUser(String name) {
        ArrayList<String> users = getUsersFromFile();
        users.add(name);

        saveUsersInFile(users);
    }

    /**
     * Connection.
     */
    public User getUserAccount() {
        createAdminIfNotExists();

        String userName;
        User user;
        boolean knownUser = false;
        while (!knownUser) {
            Utils.displayMessage("Saisissez votre nom :");
            userName = Utils.getUserResponse();

            user = new User(userName);
            knownUser = userExists(user);

            if (!knownUser) {
                Utils.displayMessage("Utilisateur incconu");
            } else {
                Utils.logMessage("Utilisateur trouvé");
                Utils.displayMessage("Bienvenue " + userName);
                return user;
            }
        }

        return null;
    }
}
