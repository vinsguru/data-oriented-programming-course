package com.vinsguru.orderservice.model.shipping;

import java.util.List;
import java.util.UUID;

public sealed interface ShippingStatus {

    record Scheduled(UUID orderId,
                     List<Shipment> shipments) implements ShippingStatus {

    }

    record Declined(UUID orderId) implements ShippingStatus {

    }

}
