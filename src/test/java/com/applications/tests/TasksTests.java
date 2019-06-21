package com.applications.tests;

import org.junit.Assert;
import org.junit.Test;

import com.applications.Task;

/**
 * Users tests class.
 * @author GTA
 */
public class TasksTests {
    @Test
    public void task() {
        Task task = new Task("Tâche");
        
        task.getName();
        task.setName("Nouvelle Tâche");
        task.getId();
        task.setId(0);
        
        Assert.assertEquals(task.getName(), "Nouvelle Tâche");
    }
}
