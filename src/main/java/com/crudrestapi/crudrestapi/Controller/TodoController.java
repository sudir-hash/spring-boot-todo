package com.crudrestapi.crudrestapi.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crudrestapi.crudrestapi.Models.Todo;
import com.crudrestapi.crudrestapi.Repositories.TodoRepository;

@RestController
public class TodoController {
    @Autowired
    TodoRepository repository;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String home() {
        return "Welcome to Todo App";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setCreated_at(LocalDate.now());
        return repository.save(todo);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/todos/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        System.out.println(todo);
        todo.setId(id);
        todo.setCreated_at(LocalDate.now());
        repository.save(todo);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/todos/{id}")
    public boolean deleteTodoById(@PathVariable int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) { 
            return false;
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/todos/deleteAll")
    public boolean deleteAllTodos(@PathVariable int id) {
        try {
            repository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
