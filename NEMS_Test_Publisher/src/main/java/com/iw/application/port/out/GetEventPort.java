package com.iw.application.port.out;

import com.iw.application.domain.model.EventPayload;

public interface GetEventPort {
    
    EventPayload getEventPayload(EventPayload eventPayload);
    
}
