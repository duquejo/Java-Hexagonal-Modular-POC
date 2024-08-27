package com.duquejo.hexagonal.tasks.config;

import com.duquejo.hexagonal.tasks.adapter.output.rest.RestAdapter;
import com.duquejo.hexagonal.tasks.port.input.GetAdditionalTaskInfoUseCase;
import com.duquejo.hexagonal.tasks.port.output.ExternalRestPort;
import com.duquejo.hexagonal.tasks.port.output.TaskRepositoryPort;
import com.duquejo.hexagonal.tasks.service.TaskService;
import com.duquejo.hexagonal.tasks.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(
            TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new GetTaskUseCaseImpl(taskRepositoryPort),
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public ExternalRestPort externalRestPort() {
        return new RestAdapter();
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalRestPort restPort) {
        return new GetAdditionalTaskInfoUseCaseImpl(restPort);
    }
}
