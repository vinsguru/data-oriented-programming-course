package com.vinsguru.orderservice.model.payment;

import java.util.UUID;

public record PaymentRequest(String customerId,
                             UUID orderId,
                             double amount) {
}
