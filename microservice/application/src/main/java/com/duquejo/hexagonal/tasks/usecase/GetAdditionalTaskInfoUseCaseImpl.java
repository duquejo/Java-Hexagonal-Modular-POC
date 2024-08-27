package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.port.input.GetAdditionalTaskInfoUseCase;
import com.duquejo.hexagonal.tasks.port.output.ExternalRestPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalRestPort restServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalRestPort restServicePort) {
        this.restServicePort = restServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return restServicePort.getAdditionalTaskInfo(id);
    }
}
