package com.max.pw.application.port.out;

import com.max.pw.application.domain.model.EventPayload;

public interface GetEventPort {
    
    EventPayload getEventPayload();
    
}
