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

    public boolean adminExists() {
        User user = new User("Admin");
        return userExists(user);
    }

    public boolean userExists(User user) {
        ArrayList<String> users = getUsersFromFile();
        return users.contains(user.name);
    }

    public void createAdminIfNotExists() {
        if (!adminExists()) {
            ArrayList<String> users = getUsersFromFile();
            users.add("Admin");

            saveUsersInFile(users);
        }
    }

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
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteUsersFile() {
        File file = new File(USERS_FILE_PATH);

        return file.delete();
    }

    public boolean usersFileExists() {
        File file = new File(USERS_FILE_PATH);

        return file.exists();
    }

    public void createUsersFileIsNotExists() {
        if (!usersFileExists()) {
            System.out.println("Création du fichier " + USERS_FILE_PATH);
            File file = new File(USERS_FILE_PATH);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createUser(String name) {
        ArrayList<String> users = getUsersFromFile();
        users.add(name);

        saveUsersInFile(users);
    }
}
