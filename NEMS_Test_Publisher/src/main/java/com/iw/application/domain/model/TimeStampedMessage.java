package com.iw.application.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeStampedMessage implements Serializable {
    String messageString;
    Date timeStamp = new Date();

    public TimeStampedMessage(String message) {
        this.messageString = message;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        String output = "TimeStampedMessage{ \"messageString\": \"%s\", \"timeStamp\": \"%s\"}";
        return String.format(output, messageString, formatter.format(timeStamp));
    }
}
