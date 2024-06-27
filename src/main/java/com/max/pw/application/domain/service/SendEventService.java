package com.max.pw.application.domain.service;

import com.max.pw.application.domain.model.EventPayload;
import com.max.pw.application.port.in.SendEventUseCase;
import com.max.pw.application.port.out.GetEventPort;
import com.max.pw.infrastructure.UseCase;

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
