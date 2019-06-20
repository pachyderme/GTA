package com.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Task manager class.
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
        ArrayList<String> results = new ArrayList<String>();

        createTasksFileIsNotExists();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(TASKS_FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                results.addAll(Arrays.asList(line.split(",")));
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
     * @param task
     * @return boolean
     */
    public boolean taskExists(Task task) {
        ArrayList<String> tasks = getTasksFromFile();
        return tasks.contains(task.name);
    }

    /**
     * Save the tasks in the tasks file.
     * 
     * @param tasks
     */
    public void saveTasksInFile(ArrayList<String> tasks) {
        try {
            FileOutputStream fos = new FileOutputStream(TASKS_FILE_PATH);

            try {
                byte[] outputResult = String.join(",", tasks).getBytes();
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
            System.out.println("Création du fichier " + TASKS_FILE_PATH);
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
     * @param name
     */
    public void createTask(String name) {
        ArrayList<String> tasks = getTasksFromFile();
        tasks.add(name);

        saveTasksInFile(tasks);
    }
}
