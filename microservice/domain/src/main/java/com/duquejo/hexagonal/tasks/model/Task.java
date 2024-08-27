package com.duquejo.hexagonal.tasks.model;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private boolean isCompleted;

    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;

    public Task() {}

    public Task(
            Long id,
            String title,
            String description,
            boolean isCompleted,
            LocalDateTime creationDate,
            LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String toString() {
        return "Task(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription()
                + ", isCompleted=" + this.isCompleted() + ", creationDate=" + this.getCreationDate() + ", updatedDate="
                + this.getUpdatedDate() + ")";
    }
}
