package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.input.CreateTaskUseCase;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
