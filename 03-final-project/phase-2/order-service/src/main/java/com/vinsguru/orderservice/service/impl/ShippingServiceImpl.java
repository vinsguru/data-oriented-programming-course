package com.vinsguru.orderservice.service.impl;

import com.vinsguru.orderservice.client.ShippingClient;
import com.vinsguru.orderservice.model.order.Order;
import com.vinsguru.orderservice.model.product.Product.*;
import com.vinsguru.orderservice.model.shipping.Recipient;
import com.vinsguru.orderservice.model.shipping.ShipmentItem;
import com.vinsguru.orderservice.model.shipping.ShippingRequest;
import com.vinsguru.orderservice.model.shipping.ShippingResponse;
import com.vinsguru.orderservice.service.ShippingService;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    private final ShippingClient shippingClient;

    public ShippingServiceImpl(ShippingClient shippingClient) {
        this.shippingClient = shippingClient;
    }

    @Override
    public ShippingResponse scheduleShipping(Order order) {
        var request = this.toShippingRequest(order);
        return this.shippingClient.schedule(request);
    }

    private ShippingRequest toShippingRequest(Order order) {
        var recipient = new Recipient(order.customer().name(), order.customer().address());
        var quantity = order.orderItem().quantity();
        var items = switch (order.orderItem().product()) {
            case Single single -> List.of(new ShipmentItem(single.productId(), quantity));
            case Bundle bundle -> bundle.items()
                                        .stream()
                                        .map(Single::productId)
                                        .map(id -> new ShipmentItem(id, quantity))
                                        .toList();
        };
        return new ShippingRequest(order.orderId(), recipient, items);
    }
}
