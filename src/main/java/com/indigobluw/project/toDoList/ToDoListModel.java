package com.indigobluw.project.toDoList;

import com.indigobluw.project.user.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "lists")
public class ToDoListModel {
    @SequenceGenerator(name = "listIdGenerator", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "listIdGenerator")
    private Long listId;
    @NotEmpty
    private String entry;
    private boolean isDone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private UserModel userModel;

    public ToDoListModel(String entry, boolean isDone, UserModel userModel) {
        this.entry = entry;
        this.isDone = isDone;
        this.userModel = userModel;
    }

    public ToDoListModel() {
    }

    public Long getListId() {
        return listId;
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