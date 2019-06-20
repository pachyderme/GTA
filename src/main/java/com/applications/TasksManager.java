package com.applications;

import java.util.ArrayList;

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
    public ArrayList<String> getTasksFromFile() {
        return FilesManager.readFile(TASKS_FILE_PATH);
    }

    /**
     * Check if a task exists.
     * 
     * @param task
     * @return boolean
     */
    public boolean taskExists(Task task) {
        boolean results = false;
        ArrayList<Task> tasks = getTasksFromFile();
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext() && !results) {
            results = it.next().id == task.id;
        }
        return results;
    }

    /**
     * Save the tasks in the tasks file.
     * 
     * @param tasks
     */
    public void saveTasksInFile(ArrayList<String> tasks) {
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
            id = 0;
        } else {
            Task lastTask = tasks.get(tasks.size() - 1);
            id = lastTask.id;
        }
        Task task = new Task(id, name);
        tasks.add(task);
        saveTasksInFile(tasks);
        return task;
    }
}
