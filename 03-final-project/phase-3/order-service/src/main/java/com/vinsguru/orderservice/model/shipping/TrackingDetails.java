package com.vinsguru.orderservice.model.shipping;

import java.time.LocalDate;

public record TrackingDetails(String carrier,
                              String trackingNumber,
                              LocalDate estimatedDeliveryDate) {
}
