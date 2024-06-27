package com.max.pw.application.port.in;

import com.max.pw.application.domain.model.EventPayload;

public interface SendEventUseCase {
    void SendEventPayload(EventPayload eventPayload);
}
