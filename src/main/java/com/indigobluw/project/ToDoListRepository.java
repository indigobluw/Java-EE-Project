package com.indigobluw.project;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Id> {
}
