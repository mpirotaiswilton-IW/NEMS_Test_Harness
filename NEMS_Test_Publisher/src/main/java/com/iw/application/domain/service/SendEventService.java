package com.iw.application.domain.service;

import com.iw.application.domain.model.EventPayload;
import com.iw.application.port.in.SendEventUseCase;
import com.iw.application.port.out.GetEventPort;
import com.iw.infrastructure.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SendEventService implements SendEventUseCase{

    private final GetEventPort getEventPort;

    @Override
    public void SendEventPayload(EventPayload eventPayload) {
        getEventPort.getEventPayload(eventPayload);
    }

    
    
}
