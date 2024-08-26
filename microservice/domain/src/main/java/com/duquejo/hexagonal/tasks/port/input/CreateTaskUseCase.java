package com.duquejo.hexagonal.tasks.port.input;

import com.duquejo.hexagonal.tasks.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
