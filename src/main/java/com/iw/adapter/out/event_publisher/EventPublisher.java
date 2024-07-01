package com.iw.adapter.out.event_publisher;

import org.springframework.stereotype.Component;

import com.iw.adapter.out.event_publisher.util.EventUtil;
import com.iw.application.domain.model.EventPayload;
import com.iw.application.domain.model.TimeStampedMessage;
import com.iw.application.port.out.GetEventPort;
import com.solace.messaging.MessagingService;
import com.solace.messaging.publisher.OutboundMessage;
import com.solace.messaging.publisher.OutboundMessageBuilder;
import com.solace.messaging.publisher.PersistentMessagePublisher;
import com.solace.messaging.resources.Topic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventPublisher implements GetEventPort {

    private final PersistentMessagePublisher publisher;
    private final MessagingService messagingService = EventUtil.ConnectBasic();

    private static final Logger logger = LogManager.getLogger();

    @Override
    public EventPayload getEventPayload(EventPayload eventPayload) {
        // System.out.println("Publisher yet to be implemented. Echoing message payload(s): " + Arrays.toString(eventPayload.getPayloadStrings()));
        SendPayloadAsMessage(eventPayload);
        return eventPayload;
    }

    private void SendPayloadAsMessage(EventPayload payload) {

        // TODO: 
        // 1. Check that topic exists in event Broker
        // 2. Pass message as an object with string message and Date timestamp 

        OutboundMessageBuilder messageBuilder = messagingService.messageBuilder();
        for(int i = 0; i < payload.getPayloadStrings().length; i++) {
            String payloadString = payload.getPayloadStrings()[i];
            TimeStampedMessage timeStampedMessage = new TimeStampedMessage(payloadString);
            OutboundMessage message = messageBuilder.build(timeStampedMessage.toString());
            try {
                System.out.println("sending message to topic [" + payload.getTopic() + "]: " + payloadString);
                publisher.publish(message, Topic.of(payload.getTopic()));
            } catch (RuntimeException e) {
                logger.warn("### Caught while trying to publisher.publish()",e);
            } finally {
                if(i + 1 < payload.getPayloadStrings().length) {
                    try {
                        // Not a big fan of this, may change this at some point
                        Thread.sleep((int)(1000 * payload.getInterval()));  // do Thread.sleep(0) for max speed
                        // Note: STANDARD Edition Solace PubSub+ broker is limited to 10k msg/s max ingress
                    } catch (InterruptedException e) {
                        logger.warn("### Caught while trying to run Thread.sleep()",e);
                    }
                }
            }
        }
    }
    
}
