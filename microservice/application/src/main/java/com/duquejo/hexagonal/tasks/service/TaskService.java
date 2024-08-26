package com.duquejo.hexagonal.tasks.service;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.input.*;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskService
        implements GetTaskUseCase,
                CreateTaskUseCase,
                DeleteTaskUseCase,
                UpdateTaskUseCase,
                GetAdditionalTaskInfoUseCase {

    private final GetTaskUseCase getTaskUseCase;
    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return getTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return getTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.updateTask(id, task);
    }
}
