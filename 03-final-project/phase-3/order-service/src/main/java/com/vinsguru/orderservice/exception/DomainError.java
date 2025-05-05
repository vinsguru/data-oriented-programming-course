package com.vinsguru.orderservice.exception;

import java.util.List;
import java.util.UUID;

public sealed interface DomainError extends ApplicationError {

    enum Entity {
        CUSTOMER,
        PRODUCT
    }

   record EntityNotFound(Entity entity,
                         String id) implements DomainError {

   }

   record ProductDiscontinued(String productId,
                              List<String> recommendedProducts) implements DomainError {

   }

   record PaymentDeclined(UUID orderId,
                          double amount) implements DomainError {

   }

    record ShippingDeclined(UUID orderId) implements DomainError {

    }

}
