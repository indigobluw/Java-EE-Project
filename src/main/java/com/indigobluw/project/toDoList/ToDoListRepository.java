package com.indigobluw.project.toDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListModel, Long> {
    //ToDoListModel findByToDoListEntry(String toDoListEntry);
}
