package com.max.pw.adapter.out.event_publisher;

import org.springframework.stereotype.Component;

import com.max.pw.application.domain.model.EventPayload;
import com.max.pw.application.port.out.GetEventPort;

@Component
public class EventPublisher implements GetEventPort {

    @Override
    public EventPayload getEventPayload(EventPayload eventPayload) {
        System.out.println("Publisher yet to be implemented. Echoing message destination topic: " + eventPayload.getTopic());
        return eventPayload;
    }
    
}
