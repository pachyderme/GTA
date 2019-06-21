package com.applications.tests;

import org.junit.Before;
import com.applications.TasksManager;
import com.applications.UsersManager;
import com.applications.Utils;

/**
 * Utils test class.
 * @author GTA
 *
 */
public class UtilsTests {
    /**
     * Users manager.
     */
    private transient UsersManager usersManager;
    /**
     * Tasks manager.
     */
    private transient TasksManager tasksManager;
    
    @Before
    public void beforeTests() {
        usersManager = new UsersManager();
        tasksManager = new TasksManager();
        Utils.setInTest(true);
        usersManager.deleteUsersFile();
        tasksManager.deleteTasksFile();
    }
}
