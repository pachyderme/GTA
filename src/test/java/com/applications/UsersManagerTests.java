package com.applications;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsersManagerTests {
    private UsersManager usersManager;

    @Before
    public void setup() {
        usersManager = new UsersManager();
        usersManager.deleteUsersFile();
    }

    @Test
    public void adminExists() {
        usersManager.deleteUsersFile();

        boolean adminExists = usersManager.adminExists();
        Assert.assertFalse(adminExists);
    }

    @Test
    public void userNotExists() {
        usersManager.deleteUsersFile();

        User user = new User("Kevin");
        boolean userExists = usersManager.userExists(user);

        Assert.assertFalse(userExists);
    }

    @Test
    public void userExists() {
        usersManager.deleteUsersFile();

        usersManager.createAdminIfNotExists();
        User user = new User("Admin");

        boolean userExists = usersManager.userExists(user);
        Assert.assertTrue(userExists);
    }

    @Test
    public void adminCreated() {
        usersManager.deleteUsersFile();
        
        usersManager.createAdminIfNotExists();
        usersManager.createAdminIfNotExists();

        boolean adminExists = usersManager.adminExists();
        Assert.assertTrue(adminExists);
    }

    @Test
    public void getUsersEmpty() {
        usersManager.deleteUsersFile();

        ArrayList<String> users = usersManager.getUsersFromFile();

        Assert.assertTrue(users.isEmpty());
    }

    @Test
    public void getUsersFilledWithAdmin() {
        usersManager.deleteUsersFile();

        usersManager.createAdminIfNotExists();

        ArrayList<String> users = usersManager.getUsersFromFile();

        Assert.assertFalse(users.isEmpty());
    }

    @Test
    public void getUsersFilledWithUser() {
        usersManager.deleteUsersFile();

        usersManager.createUser("Pierre");
        usersManager.createUser("Paul");
        usersManager.createUser("Jacques");

        ArrayList<String> users = usersManager.getUsersFromFile();

        Assert.assertEquals(users.size(), 3);
    }
    
    @Test
    public void getUserAccount() {
        
    }

    @After
    public void finish() {
        usersManager.deleteUsersFile();
    }
}
