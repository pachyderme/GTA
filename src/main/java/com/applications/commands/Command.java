package com.applications.commands;

import com.applications.LogsManager;
import com.applications.User;

/**
 * Command class.
 * @author GTA
 *
 */
public abstract class Command {

    private transient String name;
    private transient String description;
    private transient User loggedUser;

    /**
     * Constructor.
     * @param loggedTask
     */
    public Command(User loggedUser) {
        super();
        this.loggedUser = loggedUser;
    }

    public void execute() {
        LogsManager logsManager = new LogsManager(loggedUser);
        logsManager.addLog(name);
        
        action();
    }
    
    /**
     * Action executed.
     */
    public void action() {
        
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
