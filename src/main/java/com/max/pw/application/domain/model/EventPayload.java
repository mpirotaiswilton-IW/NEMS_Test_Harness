package com.max.pw.application.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EventPayload {

    @NonNull
    @NotEmpty(message = "payload must have at least one element")
    private String[] payloadStrings;

    @Positive(message = "interval must be defined as positive decimal number greater than zero")
    private double interval;

}