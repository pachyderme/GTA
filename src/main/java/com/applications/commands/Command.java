package com.applications.commands;

import com.applications.LogsManager;
import com.applications.User;

/**
 * Command class.
 * @author GTA
 *
 */
public abstract class Command {

    public transient String name;
    public transient String description;
    public transient User loggedUser;

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
}
