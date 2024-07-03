package com.iw.nems_test_subscriber.application.port.out;

// import com.iw.nems_test_subscriber.application.domain.model.EventPayload;
import com.iw.nems_test_subscriber.application.domain.model.TimeStampedMessage;

public interface GetEventPort {
    
    TimeStampedMessage getEventPayload(TimeStampedMessage timeStampedMessage);
    
}
