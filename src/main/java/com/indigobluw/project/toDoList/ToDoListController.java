package com.indigobluw.project.toDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ToDoListController {

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListController(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping("/ToDoList")
    public String getAllTodosPage(Model model) {

        model.addAttribute("todos",toDoListRepository.findAll()); //todos eller kanske entries?

        return "list"; //list.html för att vara övertydlig
    }

    @GetMapping("/ToDoList/{id}")
    public String getToDoListByIdPage(Model model, @PathVariable String id) { //lektion 4, 2:29:22
        Optional<ToDoList> todosies = toDoListRepository.findById(Long.valueOf(id));
        todosies.ifPresentOrElse(model::addAttribute, null); //if else metod
        return "listbyid";
    }

   /* ToDoListView view;
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
        model.setIsDone(isDone);
    }

    public boolean getDone() {
        return model.isDone();
    }

    public void printListDetails() {
        view.printDetails(model.getEntry(), model.isDone());
    }*/
}
