package com.applications;

/**
 * Task class.
 * 
 * @author GTA
 *
 */
public class Task extends Entity {
    private String assignedUser = "Admin";
    private int time = 0;

    public Task(String nameSelected) {
        setName(nameSelected);
    }

    public Task(int idSelected, String nameSelected) {
        setId(idSelected);
        setName(nameSelected);
    }
    
    public Task(int idSelected, String nameSelected, String assignedUserSelected) {
        setId(idSelected);
        setName(nameSelected);
        assignedUser = assignedUserSelected;
    }
    
    public Task(
            int idSelected, 
            String nameSelected, 
            String assignedUserSelected, 
            int timeSelected) {
        setId(idSelected);
        setName(nameSelected);
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
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + assignedUser + "," + time;
    }
}
