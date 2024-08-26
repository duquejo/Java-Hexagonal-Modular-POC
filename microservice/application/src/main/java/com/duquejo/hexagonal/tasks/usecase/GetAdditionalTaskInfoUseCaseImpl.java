package com.duquejo.hexagonal.tasks.usecase;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.port.input.GetAdditionalTaskInfoUseCase;
import com.duquejo.hexagonal.tasks.port.output.ExternalRestPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalRestPort restServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return restServicePort.getAdditionalTaskInfo(id);
    }
}
