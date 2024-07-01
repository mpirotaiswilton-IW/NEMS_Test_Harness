package com.iw.adapter.out.event_publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iw.adapter.out.event_publisher.util.EventUtil;
import com.solace.messaging.MessagingService;
import com.solace.messaging.publisher.PersistentMessagePublisher;

import jakarta.annotation.PreDestroy;

import java.util.Properties;

@Configuration
public class PublisherConfig {

    private static final Logger logger = LoggerFactory.getLogger(PublisherConfig.class);

    // final static Properties SOLACE_PROPERTIES = GlobalProperties.setSolaceProperties("BASIC");

    final static String QUEUE_NAME = GlobalProperties.getProperty("nems.broker.queue");
    final static String TOKEN_SERVER = GlobalProperties.getProperty("solace.auth.tokenserver");
    final static String CLIENT_ID = GlobalProperties.getProperty("solace.auth.clientid");
    final static String CLIENT_SECRET = GlobalProperties.getProperty("solace.auth.clientsecret");
    final static String SCOPE = GlobalProperties.getProperty("solace.auth.scope");
    final static String ISSUER = GlobalProperties.getProperty("solace.auth.issuer");

    // final MessagingService messagingService = EventUtil.ConnectBasic();

    PersistentMessagePublisher publisher;

    // @Bean
    // public PersistentMessagePublisher persistentMessagePublisher() {

    //     // build the publisher object
    //     publisher = messagingService.createPersistentMessagePublisherBuilder()
    //             .onBackPressureWait(1)
    //             .build();
    //     publisher.start();

    //     return publisher;
    // }

    // @PreDestroy
    // public void onDestroy(){
    //     System.out.println("Callback Triggered - @PreDestroy");
    //     System.out.println("Disconnecting publisher...");
    //     publisher.terminate(1500);
    //     messagingService.disconnect();
    // }

}
