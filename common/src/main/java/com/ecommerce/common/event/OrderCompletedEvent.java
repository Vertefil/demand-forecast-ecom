package com.ecommerce.common.event;

import com.ecommerce.common.dto.OrderLineItemDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
public class OrderCompletedEvent extends BaseEvent {

    public static final String EVENT_TYPE = "ORDER_COMPLETED";

    private final String orderId;
    private final String customerId;
    private final List<OrderLineItemDto> lineItems;

    public OrderCompletedEvent(String orderId,
                               String customerId,
                               List<OrderLineItemDto> lineItems) {
        super(EVENT_TYPE);
        this.orderId = orderId;
        this.customerId = customerId;
        this.lineItems = List.copyOf(lineItems);
    }

    @JsonCreator
    public OrderCompletedEvent(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("occurredAt") Instant occurredAt,
            @JsonProperty("eventType") String eventType,
            @JsonProperty("orderId") String orderId,
            @JsonProperty("customerId") String customerId,
            @JsonProperty("lineItems") List<OrderLineItemDto> lineItems
    ) {
        super(eventId, occurredAt, eventType);
        this.orderId = orderId;
        this.customerId = customerId;
        this.lineItems = lineItems != null ? List.copyOf(lineItems) : List.of();
    }
}
