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
 * Task manager class
 * @author GTA
 *
 */
public class TasksManager {

    private static final String TASKS_FILE_PATH = "data/tasks.csv";

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

    public boolean adminExists() {
        Task task = new Task("Admin");
        return taskExists(task);
    }

    public boolean taskExists(Task task) {
        ArrayList<String> tasks = getTasksFromFile();
        return tasks.contains(task.name);
    }

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

    public boolean deleteTasksFile() {
        File file = new File(TASKS_FILE_PATH);

        return file.delete();
    }

    public boolean tasksFileExists() {
        File file = new File(TASKS_FILE_PATH);

        return file.exists();
    }

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

    public void createTask(String name) {
        ArrayList<String> tasks = getTasksFromFile();
        tasks.add(name);

        saveTasksInFile(tasks);
    }
}
