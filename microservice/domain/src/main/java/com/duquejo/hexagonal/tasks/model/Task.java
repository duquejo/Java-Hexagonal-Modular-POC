package com.duquejo.hexagonal.tasks.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private boolean isCompleted;

    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
}
