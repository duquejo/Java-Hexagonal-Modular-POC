package com.duquejo.hexagonal.tasks.port.input;

import com.duquejo.hexagonal.tasks.model.Task;
import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
