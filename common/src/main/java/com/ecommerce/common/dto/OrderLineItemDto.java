
package com.ecommerce.common.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderLineItemDto {

    private final String productId;
    private final int quantity;
    private final BigDecimal priceAtPurchase;

    @JsonCreator
    public OrderLineItemDto(
            @JsonProperty("productId") String productId,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("priceAtPurchase") BigDecimal priceAtPurchase
    ) {
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }
}