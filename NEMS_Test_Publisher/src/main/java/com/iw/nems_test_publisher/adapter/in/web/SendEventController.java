package com.iw.nems_test_publisher.adapter.in.web;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.iw.nems_test_publisher.application.domain.model.EventPayload;
import com.iw.nems_test_publisher.application.port.in.SendEventUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
class SendPersonController {

    private final SendEventUseCase sendEventUseCase;

    @PostMapping("/")
    ResponseEntity<String> sendPerson(@Valid @RequestBody EventPayload eventPayload){
        sendEventUseCase.SendEventPayload(eventPayload);
        return new ResponseEntity<String>("new Message:" 
                + Arrays.toString(eventPayload.getPayloadStrings())
                + " | to send to topic: " 
                +  eventPayload.getTopic()
                + " | with interval: " 
                + eventPayload.getInterval()
                , HttpStatus.OK);
    }

}
