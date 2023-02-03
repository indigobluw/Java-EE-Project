package com.indigobluw.project.toDoList;

import jakarta.persistence.*;

@Entity
@Table(name= "lists")
public class ToDoListModel {
    @SequenceGenerator(name="listIdGenerator", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "listIdGenerator")
    private Long id;

    private String entry;
    private boolean isDone;

    public ToDoListModel(String entry, boolean isDone) {
        this.entry = entry;
        this.isDone = isDone;
    }
    public ToDoListModel() {
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

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}