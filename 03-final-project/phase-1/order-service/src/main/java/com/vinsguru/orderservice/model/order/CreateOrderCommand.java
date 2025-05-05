package com.vinsguru.orderservice.model.order;

import java.util.UUID;

public record CreateOrderCommand(UUID orderId,
                                 String customerId,
                                 String productId,
                                 int quantity) {

    public static CreateOrderCommand create(String customerId, String productId, int quantity){
        return new CreateOrderCommand(
            UUID.randomUUID(),
            customerId,
            productId,
            quantity
        );
    }


}
