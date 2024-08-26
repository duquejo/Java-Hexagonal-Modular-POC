package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.input.GetTaskUseCase;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTaskUseCaseImpl implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
