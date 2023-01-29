package com.indigobluw.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //webservice uses restcontroller while other controllers use controller
public class ToDoListWebServiceController {
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListWebServiceController(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping("/ToDoList")
    public String hello(Model model) { //returns string cuz it's a text doc
        model.addAttribute("message", "hello world");
        return "index.html"; //utan thymeleaf får du skriva .html, men thymeleaf behövs det inte
    }
    @GetMapping("/admin")
    public String admin () {
        return "this is admin page";
    }

    //public ResponseEntity<ToDoList, String>
}
