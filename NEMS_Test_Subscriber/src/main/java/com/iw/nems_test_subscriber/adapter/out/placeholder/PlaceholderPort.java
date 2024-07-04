package com.iw.nems_test_subscriber.adapter.out.placeholder;

import org.springframework.stereotype.Component;

import com.iw.nems_test_subscriber.application.domain.model.TimeStampedMessage;
import com.iw.nems_test_subscriber.application.port.out.GetMessagePort;

@Component
public class PlaceholderPort implements GetMessagePort {

    @Override
    public TimeStampedMessage getEventPayload(TimeStampedMessage timeStampedMessage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEventPayload'");
    }

}
