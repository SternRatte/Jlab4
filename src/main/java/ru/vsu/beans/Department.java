package ru.vsu.beans;

/**
 * class information about the Department
 */

public class Department {
    private int ID;
    private String name;

    Department(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String toString() {
        return String.valueOf(ID) + ' ' + name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
