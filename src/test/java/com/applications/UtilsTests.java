package com.applications;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Utils test class.
 * @author GTA
 *
 */
@RunWith(value = Parameterized.class)
public class UtilsTests {
    /**
     * Users manager.
     */
    private transient UsersManager usersManager;
    /**
     * Tasks manager.
     */
    private transient TasksManager tasksManager;
    
    private transient String command;

    public UtilsTests(String command) {
        this.command = command;
    }
    
    @Parameters(name = "handleCommand avec la commande {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"adduser"},
            {"addtask"},
            {"showusers"},
            {"showtasks"},
            {"help"},
            {"not exist"},
            {"exit"},
        });
    }
    
    @Before
    public void beforeTests() {
        usersManager = new UsersManager();
        tasksManager = new TasksManager();
        Utils.inTest = true;
        usersManager.deleteUsersFile();
        tasksManager.deleteTasksFile();
    }

    @Test
    public void handleCommand() {
        Utils.responseSubstitute = command;
        User user = new User("Admin");
        Utils.handleCommands(usersManager, tasksManager, user);
    }
}
