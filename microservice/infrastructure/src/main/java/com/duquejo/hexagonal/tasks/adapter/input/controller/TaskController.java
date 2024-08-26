package com.duquejo.hexagonal.tasks.adapter.input.controller;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.model.Task;
import com.duquejo.hexagonal.tasks.service.TaskService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Optional<Task> task = taskService.getTask(taskId);
        return task.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService
                .updateTask(taskId, task)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        if (!taskService.deleteTask(taskId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{taskId}/additional-info")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
    }
}
