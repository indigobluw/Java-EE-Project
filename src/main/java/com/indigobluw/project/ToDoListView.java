package com.indigobluw.project;

import jdk.swing.interop.SwingInterOpUtils;

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
