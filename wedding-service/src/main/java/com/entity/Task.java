package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String taskName;
    private String deadline;
    private boolean completed;

    // GETTER
    public boolean isCompleted() {
        return completed;
    }

    // SETTER
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // other getters/setters

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}