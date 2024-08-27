package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.port.input.DeleteTaskUseCase;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }
}
