package com.duquejo.hexagonal.tasks.entity;

import com.duquejo.hexagonal.tasks.model.Task;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public TaskEntity(
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

    public TaskEntity() {}

    /**
     * Maps a domain model Task object into a TaskEntity object.
     *
     * @param task domain model task to be mapped
     * @return TaskEntity object
     */
    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreationDate(),
                task.getUpdatedDate());
    }

    /**
     * Maps a TaskEntity object into a domain model Task
     *
     * @return Task object
     */
    public Task toDomainModel() {
        return new Task(id, title, description, isCompleted, creationDate, updatedDate);
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
}
