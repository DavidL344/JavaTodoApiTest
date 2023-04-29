package com.example.class20230429;

public class TodoItem {
    public String title;
    public String description;
    public boolean done;

    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.done = false;
    }
}
