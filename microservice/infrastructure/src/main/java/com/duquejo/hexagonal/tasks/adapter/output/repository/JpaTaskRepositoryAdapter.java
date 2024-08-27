package com.duquejo.hexagonal.tasks.adapter.output.repository;

import com.duquejo.hexagonal.tasks.entity.TaskEntity;
import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity newTask = jpaTaskRepository.save(taskEntity);
        return newTask.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Task> update(Task task) {
        if (!jpaTaskRepository.existsById(task.getId())) {
            return Optional.empty();
        }

        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity updatedTask = jpaTaskRepository.save(taskEntity);
        return Optional.of(updatedTask.toDomainModel());
    }

    @Override
    public boolean deleteById(Long taskId) {
        if (!jpaTaskRepository.existsById(taskId)) {
            return false;
        }

        jpaTaskRepository.deleteById(taskId);
        return true;
    }
}
