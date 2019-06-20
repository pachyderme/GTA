package com.applications.commands;

import java.util.Iterator;

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
    
    
    public Command(User loggedUser) {
        super();
        this.loggedUser = loggedUser;
    }

    public void execute() {
        LogsManager logsManager = new LogsManager(loggedUser);
        logsManager.addLog(name);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
