package com.vinsguru.orderservice.model.invoice;

import com.vinsguru.orderservice.model.common.PriceSummary;

import java.time.LocalDate;
import java.util.UUID;

public sealed interface Invoice {

    String id();

    record Paid(String id,
                UUID orderId,
                String customerId,
                String transactionId,
                PriceSummary priceSummary) implements Invoice {

    }

    record Unpaid(String id,
                  UUID orderId,
                  String customerId,
                  String businessTaxId,
                  PriceSummary priceSummary,
                  LocalDate paymentDue) implements Invoice {

    }

}
