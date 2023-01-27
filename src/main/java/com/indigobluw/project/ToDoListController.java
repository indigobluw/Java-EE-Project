package com.indigobluw.project;

public class ToDoListController {

    ToDoListView view;
    ToDoList model;

    public ToDoListController(ToDoListView view, ToDoList model) {
        this.view = view;
        this.model = model;
    }

    public void setEntry(String entry) {
        model.setEntry(entry);
    }

    public String getEntry() {
        return model.getEntry();
    }

    public void setIsDone(boolean isDone) {
        model.setDone(isDone);
    }

    public boolean getIsDone() {
        return model.getIsDone();
    }
}
