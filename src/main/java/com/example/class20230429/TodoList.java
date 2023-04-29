package com.example.class20230429;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<TodoItem> items;

    public TodoList() {
        items = new ArrayList<TodoItem>();
    }

    public TodoList(List<TodoItem> items) {
        this.items = items;
    }

    public void addItem(TodoItem item) {
        items.add(item);
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public void updateItem(TodoItem item) {
        int index = items.indexOf(item);
        items.set(index, item);
    }

    public void markItem(TodoItem item, boolean done) {
        int index = items.indexOf(item);
        markItem(index, done);
    }

    public void markItem(int index, boolean done) {
        TodoItem item = items.get(index);
        item.done = done;
        items.set(index, item);
    }

    public void removeItem(TodoItem item) {
        items.remove(item);
    }
}
