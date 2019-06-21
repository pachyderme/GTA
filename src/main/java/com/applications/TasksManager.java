package com.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Task manager class.
 * 
 * @author GTA
 *
 */
public class TasksManager {

    private static final String TASKS_FILE_PATH = "data/tasks.csv";

    /**
     * Get the tasks from the tasks file.
     * 
     * @return tasks
     */
    public ArrayList<Task> getTasksFromFile() {
        ArrayList<String> names = FilesManager.readFile(TASKS_FILE_PATH);
        ArrayList<Task> results = new ArrayList<Task>();
        
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            List<String> tmpTask = Arrays.asList(it.next().split(","));
            int id = Integer.parseInt(tmpTask.get(0));
            int time = Integer.parseInt(tmpTask.get(3));
            Task task = new Task(id, tmpTask.get(1), tmpTask.get(2), time);
            results.add(task);
        }
        
        return results;
    }

    /**
     * Check if a task exists.
     * 
     * @param task
     * @return boolean
     */
    public boolean taskExists(Task task) {
        return taskExists(getTasksFromFile(), task);
    }

    /**
     * Check if a task exists.
     * 
     * @param tasks
     * @param task
     * @return boolean
     */
    public boolean taskExists(ArrayList<Task> tasks, Task task) {
        boolean results = false;
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext() && !results) {
            results = it.next().getId() == task.getId();
        }
        return results;
    }

    /**
     * get a task by its id.
     * 
     * @param tasks
     * @param id
     * @return task
     */
    public Task getTask(ArrayList<Task> tasks, int id) {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    

    /**
     * Save the tasks in the tasks file.
     * 
     * @param tasks
     */
    public void saveTasksInFile(ArrayList<Task> tasks) {
        FilesManager.saveItemsInFile(TASKS_FILE_PATH, tasks);
    }

    /**
     * Delete the tasks file.
     * 
     * @return boolean
     */
    public boolean deleteTasksFile() {
        return FilesManager.deleteFile(TASKS_FILE_PATH);
    }

    /**
     * Check if the tasks file exists.
     * 
     * @return boolean
     */
    public boolean tasksFileExists() {
        return FilesManager.fileExists(TASKS_FILE_PATH);
    }

    /**
     * Create the tasks file if is not exists.
     */
    public void createTasksFileIsNotExists() {
        FilesManager.createFileIsNotExists(TASKS_FILE_PATH);
    }

    /**
     * Create a task.
     * 
     * @param name
     */
    public Task createTask(String name) {
        ArrayList<Task> tasks = getTasksFromFile();
        int id;
        if (tasks.isEmpty()) {
            id = 1;
        } else {
            Task lastTask = tasks.get(tasks.size() - 1);
            id = lastTask.getId() + 1;
        }
        Task task = new Task(id, name);
        tasks.add(task);
        saveTasksInFile(tasks);
        return task;
    }
}
