package com.applications;

/**
 * User class.
 * @author GTA
 */
public class User extends Entity {
    public String type;

    public User(String nameSelected) {
        name = nameSelected;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getName();
    }

    
}
