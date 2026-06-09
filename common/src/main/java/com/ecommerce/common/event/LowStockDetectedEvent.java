package com.ecommerce.common.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;

@Getter
public class LowStockDetectedEvent extends BaseEvent {

    public static final String EVENT_TYPE = "LOW_STOCK_DETECTED";

    private final String productId;
    private final int currentStock;
    private final int threshold;

    public LowStockDetectedEvent(String productId,
                                 int currentStock,
                                 int threshold
    ) {
        super(EVENT_TYPE);
        this.productId = productId;
        this.currentStock = currentStock;
        this.threshold = threshold;
    }

    @JsonCreator
    public LowStockDetectedEvent(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("occurredAt") Instant occurredAt,
            @JsonProperty("eventType") String eventType,
            @JsonProperty("productId") String productId,
            @JsonProperty("currentStock") int currentStock,
            @JsonProperty("threshold") int threshold
    ) {
        super(eventId, occurredAt, eventType);
        this.productId = productId;
        this.currentStock = currentStock;
        this.threshold = threshold;
    }
}
