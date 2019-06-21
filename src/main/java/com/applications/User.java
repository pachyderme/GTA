package com.applications;

/**
 * User class.
 * @author GTA
 */
public class User extends Entity {
    private String type;

    public User(String nameSelected) {
        setName(nameSelected);
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
