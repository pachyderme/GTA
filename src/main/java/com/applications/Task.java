package com.applications;

/**
 * Task class.
 * 
 * @author GTA
 *
 */
public class Task {
    public String name;
    public int id;
    public String assignedUser = "Admin";

    public Task(String nameSelected) {
        name = nameSelected;
    }

    public Task(int idSelected, String nameSelected) {
        id = idSelected;
        name = nameSelected;
    }
    
    public Task(int idSelected, String nameSelected, String assignedUserSelected) {
        id = idSelected;
        name = nameSelected;
        assignedUser = assignedUserSelected;
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

    @Override
    public String toString() {
        return id + "," + name + "," + assignedUser;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

}
