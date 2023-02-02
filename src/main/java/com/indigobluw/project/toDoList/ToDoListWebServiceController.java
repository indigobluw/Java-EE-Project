package com.indigobluw.project.toDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //webservice uses restcontroller while other controllers use controller
public class ToDoListWebServiceController {
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListWebServiceController(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping("/ws/ToDoList")
    public ResponseEntity<List<ToDoList>> getAllToDoLists(){

        return new ResponseEntity<>(toDoListRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/ws/ToDoList")
    public ResponseEntity<ToDoList> saveList(@RequestBody ToDoList toDoList) {

        return new ResponseEntity<>(toDoListRepository.save(toDoList), HttpStatus.OK);
    }
    /*public String hello(Model model) { //returns string cuz it's a text doc
        model.addAttribute("message", "hello world");
        return "index.html"; //utan thymeleaf får du skriva .html, men thymeleaf behövs det inte
    }
    @GetMapping("/ws/admin")
    public String admin () {
        return "this is admin page";
    }*/


}
