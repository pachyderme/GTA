package com.applications.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.applications.CommandsManager;
import com.applications.TasksManager;
import com.applications.User;
import com.applications.UsersManager;
import com.applications.Utils;

/**
 * Commands manager test class.
 * @author GTA
 *
 */
@RunWith(value = Parameterized.class)
public class CommandsManagerTests {
    /**
     * Commands manager.
     */
    private transient CommandsManager commandsManager;
    /**
     * Users manager.
     */
    private transient UsersManager usersManager;
    /**
     * Tasks manager.
     */
    private transient TasksManager tasksManager;
    
    private transient String command;

    public CommandsManagerTests(String command) {
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
        commandsManager = new CommandsManager(new User("Test"));
        usersManager = new UsersManager();
        tasksManager = new TasksManager();
        Utils.inTest = true;
    }

    @Test
    public void handleCommand() {
        Utils.responseSubstitute = command;
        
        CommandsManager commandsManager = new CommandsManager(new User("Test"));
        commandsManager.handleCommands(usersManager, tasksManager);
    }

}
