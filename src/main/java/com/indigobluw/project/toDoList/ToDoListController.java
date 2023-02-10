package com.indigobluw.project.toDoList;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        model.addAttribute("todos", toDoListRepository.findAll()); //todos eller kanske entries?

        return "list"; //list.html för att vara övertydlig
    }

    @GetMapping("/ToDoList/{id}")
    public String getToDoListByIdPage(Model model, @PathVariable String id) { //lektion 4, 2:29:22
        Optional<ToDoListModel> todosies = toDoListRepository.findById(Long.valueOf(id));
        todosies.ifPresentOrElse(model::addAttribute, null); //if else metod
        return "listbyid";
    }

    @PostMapping("/ToDoList")
    public String postList(@Valid ToDoListModel toDoListModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "list";
        }
        toDoListRepository.save(toDoListModel);
        return "list";
    }
}
