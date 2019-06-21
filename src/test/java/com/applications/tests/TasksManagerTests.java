package com.applications.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.applications.Task;
import com.applications.TasksManager;
import com.applications.Utils;

/**
 * Tasks manager tests class.
 * 
 * @author GTA
 */
public class TasksManagerTests {
    /**
     * Tasks manager.
     */
    private transient TasksManager tasksManager;

    @Before
    public void beforeTests() {
        tasksManager = new TasksManager();
        tasksManager.deleteTasksFile();
        Utils.inTest = true;
    }

    @Test
    public void taskExists() {
        Task task = new Task("Tester");
        tasksManager.deleteTasksFile();

        Task receivedTask = tasksManager.createTask(task.getName());
        
        boolean taskExists = tasksManager.taskExists(receivedTask);
        Assert.assertTrue(taskExists);
    }

}
