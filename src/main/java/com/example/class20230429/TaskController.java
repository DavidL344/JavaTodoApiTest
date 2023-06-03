package com.example.class20230429;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<TodoList> getAllTasks() {
        TodoList list = new TodoList();

        List<TodoList> data = jdbcTemplate.query("select * from tasks", (rs, rowNum) -> {
            TodoItem task = new TodoItem(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getBoolean("done"));
            list.addItem(task);
            return list;
        });

        return data;
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
