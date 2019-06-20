package com.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
        ArrayList<Task> results = new ArrayList<Task>();

        createTasksFileIsNotExists();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(TASKS_FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                List<String> tmp = Arrays.asList(line.split(";"));
                Iterator<String> it = tmp.iterator();
                while (it.hasNext()) {
                    List<String> tmpTask = Arrays.asList(it.next().split(","));
                    int taskId = Integer.parseInt(tmpTask.get(0));
                    Task task = new Task(taskId, tmpTask.get(1), tmpTask.get(2));
                    results.add(task);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
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
    public void saveTasksInFile(ArrayList<Task> tasks) {
        Iterator<Task> it = tasks.iterator();
        ArrayList<String> fileContent = new ArrayList<String>();
        while (it.hasNext()) {
            fileContent.add(it.next().toString());
        }
        try {
            FileOutputStream fos = new FileOutputStream(TASKS_FILE_PATH);

            try {
                byte[] outputResult = String.join(";", fileContent).getBytes();
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
                    } else {
                        Utils.logMessage("fileOutPutStream déjà vide");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete the tasks file.
     * 
     * @return boolean
     */
    public boolean deleteTasksFile() {
        File file = new File(TASKS_FILE_PATH);

        return file.delete();
    }

    /**
     * Check if the tasks file exists.
     * 
     * @return boolean
     */
    public boolean tasksFileExists() {
        File file = new File(TASKS_FILE_PATH);

        return file.exists();
    }

    /**
     * Create the tasks file if is not exists.
     */
    public void createTasksFileIsNotExists() {
        if (!tasksFileExists()) {
            Utils.logMessage("Création du fichier " + TASKS_FILE_PATH);
            File file = new File(TASKS_FILE_PATH);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
