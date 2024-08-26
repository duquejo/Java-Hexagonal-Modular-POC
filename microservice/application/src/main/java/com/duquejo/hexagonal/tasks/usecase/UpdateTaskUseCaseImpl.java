package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.input.UpdateTaskUseCase;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(t -> {
                    t.setTitle(updateTask.getTitle());
                    t.setDescription(updateTask.getDescription());
                    t.setCompleted(updateTask.isCompleted());
                    return taskRepository.update(t);
                })
                .orElse(Optional.empty());
    }
}
