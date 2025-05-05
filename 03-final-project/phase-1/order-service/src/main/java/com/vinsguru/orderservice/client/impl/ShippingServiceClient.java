package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.ShippingClient;
import com.vinsguru.orderservice.model.shipping.ShippingRequest;
import com.vinsguru.orderservice.model.shipping.ShippingResponse;
import org.springframework.web.client.RestClient;

import java.util.Collections;

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
    public ShippingResponse schedule(ShippingRequest request) {
        return this.executeRequest(
                () -> this.restClient.post()
                                     .uri("/schedule")
                                     .body(request)
                                     .retrieve()
                                     .body(ShippingResponse.class),
                Collections.emptyMap()
        );
    }

}
