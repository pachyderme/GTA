package com.applications.commands;

import com.applications.Utils;

public abstract class Command {

    public String name;
    public String description;
    
    public void execute() {
        Utils.displayMessage("[Commande exécutée: " + name + "]");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
