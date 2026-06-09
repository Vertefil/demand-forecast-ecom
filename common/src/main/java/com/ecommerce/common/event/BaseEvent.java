package com.ecommerce.common.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public abstract class BaseEvent {

    private final String eventId;
    private final Instant occurredAt;
    private final String eventType;

    protected BaseEvent(String eventType) {
        this.eventId = UUID.randomUUID().toString();
        this.occurredAt = Instant.now();
        this.eventType = eventType;
    }

    @JsonCreator
    protected BaseEvent(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("occurredAt") Instant occurredAt,
            @JsonProperty("eventType") String eventType
    ) {
        this.eventId = eventId;
        this.occurredAt = occurredAt;
        this.eventType = eventType;
    }
}