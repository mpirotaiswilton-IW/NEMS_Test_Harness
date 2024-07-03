package com.iw.nems_test_subscriber.application.port.in;

// import com.iw.nems_test_subscriber.application.domain.model.EventPayload;
import com.iw.nems_test_subscriber.application.domain.model.TimeStampedMessage;

public interface SendEventUseCase {
    void SendEventPayload(TimeStampedMessage timeStampedMessage);
}
