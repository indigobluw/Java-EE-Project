package com.indigobluw.project;

public class ToDoListView {
    public void printDetails(String toDoListEntry, boolean isDone) {
        System.out.printf("""
                Printing details
                toDoListEntry: %s
                isDone: %s
                """,
                toDoListEntry, isDone);
    }
}
