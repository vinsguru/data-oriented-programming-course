package com.vinsguru.orderservice.model.shipping;

public record Shipment(String shipmentId,
                       String productId,
                       int quantity,
                       String shippingAddress,
                       TrackingDetails trackingDetails) {
}
