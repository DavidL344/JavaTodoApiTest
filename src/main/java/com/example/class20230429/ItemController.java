package com.example.class20230429;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<TodoItem> getAllItems() {
        return jdbcTemplate.query("SELECT * FROM items ORDER BY id ASC", (rs, rowNum) -> {
            TodoItem item = new TodoItem(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getBoolean("done"));
            return item;
        });
    }

    @GetMapping("/{id}")
    public TodoList getItem(@PathVariable("id") Integer id) {
        List<TodoList> query = jdbcTemplate.query("SELECT * FROM items WHERE id = ?", new Object[]{id}, (rs, rowNum) -> {
            TodoItem item = new TodoItem(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getBoolean("done"));
            TodoList list = new TodoList();
            list.addItem(item);
            return list;
        });
        return query == null || query.size() == 0 ? null : query.get(0);
    }

    @PostMapping("")
    public TodoItem createItem(@RequestBody TodoItem item) {
        Integer id = jdbcTemplate.queryForObject("SELECT MAX(id) FROM items", Integer.class) + 1;
        int affectedRows = jdbcTemplate.update("INSERT INTO items (id, title, description, done) VALUES (?, ?, ?, ?)",
                id, item.title, item.description, item.done);

        item.id = id;
        return item;
    }

    @PutMapping("/{id}")
    public TodoItem updateItem(@PathVariable("id") Integer id, @RequestBody TodoItem item) {
        jdbcTemplate.update("UPDATE items SET title = ?, description = ?, done = ? WHERE id = ?",
                item.title, item.description, item.done, id);

        item.id = id;
        return item;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        jdbcTemplate.update("DELETE FROM items WHERE id = ?", id);
    }
}
