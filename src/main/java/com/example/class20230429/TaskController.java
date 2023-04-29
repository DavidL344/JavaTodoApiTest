package com.example.class20230429;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @GetMapping("")
    public List<String> getAllTasks() {
        return new ArrayList<String>();
    }

    @PostMapping("")
    public String createTask(@RequestBody String task) {
        return task;
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") String id) {
        return id;
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable("id") String id, @RequestBody String task) {
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") String id) {
        return id;
    }
}
