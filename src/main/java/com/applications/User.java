package com.applications;

/**
 * User class.
 * @author GTA
 */
public class User {
    public String type;
    public String name;
    public int id;

    public User(String nameSelected) {
        name = nameSelected;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return getName();
    }

    
}
