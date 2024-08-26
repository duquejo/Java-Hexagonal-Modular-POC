package com.duquejo.hexagonal.tasks.port.input;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
