package com.applications.tests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.applications.User;
import com.applications.UsersManager;
import com.applications.Utils;

/**
 * Users manager tests class.
 * 
 * @author GTA
 */
public class UsersManagerTests {
    /**
     * Users manager.
     */
    private transient UsersManager usersManager;

    @Before
    public void beforeTests() {
        usersManager = new UsersManager();
        usersManager.deleteUsersFile();
        Utils.inTest = true;
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

        List<String> users = usersManager.getUsersFromFile();

        Assert.assertTrue(users.isEmpty());
    }

    @Test
    public void getUsersFilledWithAdmin() {
        usersManager.deleteUsersFile();

        usersManager.createAdminIfNotExists();

        List<String> users = usersManager.getUsersFromFile();

        Assert.assertFalse(users.isEmpty());
    }

    @Test
    public void getUsersFilledWithUser() {
        usersManager.deleteUsersFile();

        usersManager.createUser("Pierre");

        List<String> users = usersManager.getUsersFromFile();

        Assert.assertEquals(users.size(), 1);
    }

    @Test
    public void getUserAccount() {
        Utils.responseSubstitute = "Admin";
        usersManager.createAdminIfNotExists();
        User user = usersManager.getUserAccount();

        Assert.assertEquals(user.getName(), "Admin");
    }

    @After
    public void afterTests() {
        usersManager.deleteUsersFile();
        Utils.inTest = false;
    }
}
