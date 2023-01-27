package com.indigobluw.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListWebServiceController {
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListWebServiceController(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping("/ws/ToDoList")
    public String hello(Model model) {
        model.addAttribute("message", "hello world");
        return "mains.html";
    }
    @GetMapping("/admin")
    public String admin () {
        return "this is admin page";
    }

    //public ResponseEntity<ToDoList, String>
}
