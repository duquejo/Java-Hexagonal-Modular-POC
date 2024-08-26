package com.duquejo.hexagonal.tasks.port.output;

import com.duquejo.hexagonal.tasks.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Optional<Task> update(Task task);

    boolean deleteById(Long taskId);
}
