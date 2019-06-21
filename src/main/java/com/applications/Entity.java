package com.applications;

/**
 * Entity class
 * @author pierr
 *
 */
public abstract class Entity {
    public String name;
    public int id;
    
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
