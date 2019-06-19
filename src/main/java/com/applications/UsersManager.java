package com.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UsersManager {
    private static final String USERS_FILE_PATH = "data/users.csv";
    
    /**
     * Get the users from the users file
     * @return
     */
    public ArrayList<String> getUsersFromFile() {
        ArrayList<String> results = new ArrayList<String>();
        
        createUsersFileIsNotExists();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(USERS_FILE_PATH));
            String line = null;
            while ((line = reader.readLine()) != null) {
                results.addAll(Arrays.asList(line.split(",")));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
    
    /**
     * Check if the admin user exists
     * @return
     */
    public boolean adminExists() {
        User user = new User("Admin");
        return userExists(user);
    }
    
    /**
     * Check if a user exists
     * @param user
     * @return boolean
     */
    public boolean userExists(User user) {
        ArrayList<String> users = getUsersFromFile();
        return users.contains(user.name);
    }
    
    /**
     * Create the admin user if not exists
     */
    public void createAdminIfNotExists() {
        if (!adminExists()) {
            ArrayList<String> users = getUsersFromFile();
            users.add("Admin");

            saveUsersInFile(users);
        }else {
            Utils.logMessage("L'administrateur existe déjà.");
        }
    }
    
    /**
     * Save the users in the users file
     * @param users
     */
    public void saveUsersInFile(ArrayList<String> users) {
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(USERS_FILE_PATH);
            byte[] outputResult = String.join(",", users).getBytes();
            fos.write(outputResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }else {
                    Utils.logMessage("fileOutPutStream déjà vide");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Delete the users file
     * @return boolean
     */
    public boolean deleteUsersFile() {
        File file = new File(USERS_FILE_PATH);
        return file.delete();
    }
    
    /**
     * Check if the users file exists
     * @return boolean
     */
    public boolean usersFileExists() {
        File file = new File(USERS_FILE_PATH);
        return file.exists();
    }
    
    /**
     * Create user file if the users file not exists
     */
    public void createUsersFileIsNotExists() {
        if (!usersFileExists()) {
            Utils.logMessage("Création du fichier " + USERS_FILE_PATH);

            File file = new File(USERS_FILE_PATH);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Create a user
     * @param name
     */
    public void createUser(String name) {
        ArrayList<String> users = getUsersFromFile();
        users.add(name);

        saveUsersInFile(users);
    }
    
    /**
     * Connection
     */
    public User getUserAccount() {
        createAdminIfNotExists();
                
        String userName = "";
        User user = null;
        boolean knownUser = false;
        while (!knownUser) {
            Utils.displayMessage("Saisissez votre nom :");
            userName = Utils.getUserResponse();
            
            user = new User(userName);
            knownUser = userExists(user);
            
            if (!knownUser) {
                Utils.displayMessage("Utilisateur incconu");
            }else {
                Utils.logMessage("Utilisateur trouvé");
            }
        }
        
        Utils.displayMessage("Bienvenue " + userName);
        
        return user;
    }
}
