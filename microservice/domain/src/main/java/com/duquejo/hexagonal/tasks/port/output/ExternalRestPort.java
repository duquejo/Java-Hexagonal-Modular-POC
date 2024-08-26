package com.duquejo.hexagonal.tasks.port.output;

import com.duquejo.hexagonal.tasks.model.AdditionalTaskInfo;

public interface ExternalRestPort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
