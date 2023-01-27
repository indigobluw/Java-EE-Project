package com.indigobluw.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ToDoList {
    @Id
    private Long Id;

    public Long getId() {
        return Id;
    }

    private String entry;

    public ToDoList() {
    }

    private boolean isDone;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
