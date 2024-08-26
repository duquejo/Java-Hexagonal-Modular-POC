package com.duquejo.hexagonal.tasks.port.input;

import com.duquejo.hexagonal.tasks.model.Task;
import java.util.List;
import java.util.Optional;

public interface GetTaskUseCase {
    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();
}
