package com.iw.nems_test_publisher.adapter.out.event_publisher;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.iw.nems_test_publisher.application.domain.model.EventPayload;
import com.iw.nems_test_publisher.application.port.out.GetEventPort;

@Component
public class EventPublisher implements GetEventPort {

    @Override
    public EventPayload getEventPayload(EventPayload eventPayload) {
        System.out.println("Publisher yet to be implemented. Echoing message payload(s): " + Arrays.toString(eventPayload.getPayloadStrings()));
        return eventPayload;
    }
    
}
