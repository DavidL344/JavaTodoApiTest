package com.example.class20230429;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @GetMapping("")
    public List<TodoList> getAllTasks() {
        return new ArrayList<>();
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoList createTask(@RequestBody TodoList task) {
        return task;
    }

    @GetMapping("/{id}")
    public TodoList getTask(@PathVariable("id") String id) {
        return new TodoList();
    }

    @PutMapping("/{id}")
    public TodoList updateTask(@PathVariable("id") String id, @RequestBody TodoList task) {
        return task;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") String id) {
        return;
    }
}
