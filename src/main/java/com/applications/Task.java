package com.applications;

/**
 * Task class
 * @author GTA
 *
 */
public class Task {
    public String name;
    public int id;

    public Task(String nameSelected) {
        name = nameSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
