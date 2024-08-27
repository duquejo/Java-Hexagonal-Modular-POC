package com.duquejo.hexagonal.tasks.service;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.input.*;
import java.util.List;
import java.util.Optional;

public class TaskService {

    private final GetTaskUseCase getTaskUseCase;
    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(
            GetTaskUseCase getTaskUseCase,
            CreateTaskUseCase createTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.getTaskUseCase = getTaskUseCase;
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    public Optional<Task> getTask(Long id) {
        return getTaskUseCase.getTask(id);
    }

    public List<Task> getAllTasks() {
        return getTaskUseCase.getAllTasks();
    }

    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.updateTask(id, task);
    }
}
