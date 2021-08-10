package com.codegym;

public class Student {
    private String name="John";
    private String classes="C06";

    Student(){
    }

    public void setName(String newName){
        this.name = newName;
    }
    public void setClasses(String newClasses) {
        this.classes = newClasses;
    }
    public String toString() {
        return "Name: " + this.name + " Class: " + this.classes;
    }
}
