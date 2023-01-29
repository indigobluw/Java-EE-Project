package com.indigobluw.project;

import jakarta.persistence.*;

@Entity
@Table(name= "lists")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String entry;
    private boolean isDone;

    public ToDoList(String entry, boolean isDone) {
        this.entry = entry;
        this.isDone = isDone;
    }
    public ToDoList() {
    }

    public Long getId() {
        return id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}