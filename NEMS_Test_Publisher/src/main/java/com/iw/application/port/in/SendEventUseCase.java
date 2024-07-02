package com.iw.application.port.in;

import com.iw.application.domain.model.EventPayload;

public interface SendEventUseCase {
    void SendEventPayload(EventPayload eventPayload);
}
