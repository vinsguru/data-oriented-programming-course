package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.ShippingClient;
import com.vinsguru.orderservice.model.shipping.ShippingRequest;
import com.vinsguru.orderservice.model.shipping.ShippingStatus;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.function.Supplier;

public class ShippingServiceClient extends AbstractServiceClient implements ShippingClient {

    private final RestClient restClient;

    public ShippingServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "shipping-service";
    }

    @Override
    public ShippingStatus schedule(ShippingRequest request) {
        var errorMap = Map.<Integer, Supplier<ShippingStatus>>of(
                422, () -> new ShippingStatus.Declined(request.orderId())
        );
        return this.executeRequest(
                () -> this.restClient.post()
                                     .uri("/schedule")
                                     .body(request)
                                     .retrieve()
                                     .body(ShippingStatus.Scheduled.class),
                errorMap
        );
    }

}
