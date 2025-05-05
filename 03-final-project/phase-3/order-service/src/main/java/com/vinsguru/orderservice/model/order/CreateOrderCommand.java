package com.vinsguru.orderservice.model.order;

import java.util.Optional;
import java.util.UUID;

public record CreateOrderCommand(UUID orderId,
                                 String customerId,
                                 String productId,
                                 int quantity,
                                 Optional<String> couponCode) {

    public static CreateOrderCommand create(String customerId, String productId, int quantity, String couponCode) {
        return new CreateOrderCommand(
                UUID.randomUUID(),
                customerId,
                productId,
                quantity,
                Optional.ofNullable(couponCode)
        );
    }


}
