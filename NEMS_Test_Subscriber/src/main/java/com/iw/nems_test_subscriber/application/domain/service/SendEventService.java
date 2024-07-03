package com.iw.nems_test_subscriber.application.domain.service;

import com.iw.nems_test_subscriber.application.domain.model.TimeStampedMessage;
//import com.iw.nems_test_subscriber.application.domain.model.EventPayload;
import com.iw.nems_test_subscriber.application.port.in.SendEventUseCase;
import com.iw.nems_test_subscriber.application.port.out.GetEventPort;
import com.iw.nems_test_subscriber.infrastructure.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SendEventService implements SendEventUseCase{

    private final GetEventPort getEventPort;

    @Override
    public void SendEventPayload(TimeStampedMessage timeStampedMessage) {
        getEventPort.getEventPayload(timeStampedMessage);
    }

    
    
}
