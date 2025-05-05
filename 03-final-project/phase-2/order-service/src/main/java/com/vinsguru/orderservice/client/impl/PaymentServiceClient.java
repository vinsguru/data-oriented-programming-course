package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.PaymentClient;
import com.vinsguru.orderservice.model.payment.PaymentRequest;
import com.vinsguru.orderservice.model.payment.PaymentStatus;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.function.Supplier;

public class PaymentServiceClient extends AbstractServiceClient implements PaymentClient {

    private final RestClient restClient;

    public PaymentServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "payment-service";
    }

    @Override
    public PaymentStatus process(PaymentRequest request) {
        var errorMap = Map.<Integer, Supplier<PaymentStatus>>of(
            402, () -> new PaymentStatus.Declined(request.orderId(), request.amount())
        );
        return this.executeRequest(
                () -> this.restClient.post()
                        .uri("/process")
                        .body(request)
                        .retrieve()
                        .body(PaymentStatus.Processed.class),
                errorMap
        );
    }

}
