package com.example.class20230429;

public class TodoItem {
    public Integer id;
    public String title;
    public String description;
    public boolean done;

    public TodoItem() {

    }

    public TodoItem(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = false;
    }

    public TodoItem(Integer id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }
}
