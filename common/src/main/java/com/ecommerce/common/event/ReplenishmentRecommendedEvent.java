package com.ecommerce.common.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;

@Getter
public class ReplenishmentRecommendedEvent extends BaseEvent {

    public static final String EVENT_TYPE = "REPLENISHMENT_RECOMMENDED";

    private final String productId;
    private final int forecastedDemand;
    private final int recommendedOrderQuantity;
    private final int forecastPeriodDays;
    private final double confidenceScore;
    private final ForecastAlgorithm algorithm;

    public ReplenishmentRecommendedEvent(String productId,
                                         int forecastedDemand,
                                         int recommendedOrderQuantity,
                                         int forecastPeriodDays,
                                         double confidenceScore,
                                         ForecastAlgorithm algorithm
    ) {
        super(EVENT_TYPE);
        validateConfidenceScore(confidenceScore);
        this.productId = productId;
        this.forecastedDemand = forecastedDemand;
        this.recommendedOrderQuantity = recommendedOrderQuantity;
        this.forecastPeriodDays = forecastPeriodDays;
        this.confidenceScore = confidenceScore;
        this.algorithm = algorithm;
    }

    @JsonCreator
    public ReplenishmentRecommendedEvent(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("occurredAt") Instant occurredAt,
            @JsonProperty("eventType") String eventType,
            @JsonProperty("productId") String productId,
            @JsonProperty("forecastedDemand") int forecastedDemand,
            @JsonProperty("recommendedOrderQuantity") int recommendedOrderQuantity,
            @JsonProperty("forecastPeriodDays") int forecastPeriodDays,
            @JsonProperty("confidenceScore") double confidenceScore,
            @JsonProperty("algorithm") ForecastAlgorithm algorithm
    ) {
        super(eventId, occurredAt, eventType);
        validateConfidenceScore(confidenceScore);
        this.productId = productId;
        this.forecastedDemand = forecastedDemand;
        this.recommendedOrderQuantity = recommendedOrderQuantity;
        this.forecastPeriodDays = forecastPeriodDays;
        this.confidenceScore = confidenceScore;
        this.algorithm = algorithm;
    }

    private static void validateConfidenceScore(double score) {
        if (score < 0.0 || score > 1.0) {
            throw new IllegalArgumentException(
                    "Confidence score must be between 0.0 and 1.0, got: " + score
            );
        }
    }
}
