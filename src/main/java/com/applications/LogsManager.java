package com.applications;

import java.util.List;

/**
 * Logs manager class.
 * @author kevin
 *
 */
public class LogsManager {

    private static final String BEGIN_LOG_FILE_PATH = "data/logs/";

    protected transient User loggedUser;
    protected transient String path;

    /**
     * Constructor.
     * @param loggedUser
     */
    public LogsManager(User loggedUser) {
        this.loggedUser = loggedUser;
        this.path = BEGIN_LOG_FILE_PATH + loggedUser.getName() + ".log"; 
    }
    
    /**
     * Get the logs from the logs file.
     * 
     * @return logs
     */
    public List<String> getLogsFromFile() {
        return FilesManager.readFile(path);
    }
    
    public void addLog(String name) {
        List<String> logs = getLogsFromFile();
        logs.add(name);
        saveLogsInFile(logs);
    }

    /**
     * Check if a task exists.
     * @param task
     * @return boolean
     */
    public boolean taskExists(Task task) {
        List<String> logs = getLogsFromFile();
        return logs.contains(task.getName());
    }

    /**
     * Save the logs in the logs file.
     * 
     * @param logs
     */
    public void saveLogsInFile(List<String> logs) {
        FilesManager.saveItemsInFile(path, logs);
    }

    /**
     * Delete the logs file.
     * 
     * @return boolean
     */
    public boolean deleteLogsFile() {
        return FilesManager.deleteFile(path);
    }

    /**
     * Check if the logs file exists.
     * 
     * @return boolean
     */
    public boolean logsFileExists() {
        return FilesManager.fileExists(path);
    }

    /**
     * Create the logs file if is not exists.
     */
    public void createLogsFileIsNotExists() {
        FilesManager.createFileIsNotExists(path);
    }

    /**
     * Create a task.
     * @param name
     */
    public void createTask(String name) {
        List<String> logs = getLogsFromFile();
        logs.add(name);

        saveLogsInFile(logs);
    }
}
