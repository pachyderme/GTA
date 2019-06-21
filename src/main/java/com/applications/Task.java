package com.applications;

/**
 * Task class.
 * 
 * @author GTA
 *
 */
public class Task extends Entity {
    public String assignedUser = "Admin";
    public int time = 0;

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
    
    public Task(
            int idSelected, 
            String nameSelected, 
            String assignedUserSelected, 
            int timeSelected) {
        id = idSelected;
        name = nameSelected;
        assignedUser = assignedUserSelected;
        time = timeSelected;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public int getTime() {
        return id;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + assignedUser + "," + time;
    }
}
