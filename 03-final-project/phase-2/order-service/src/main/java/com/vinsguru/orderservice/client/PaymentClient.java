package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.payment.PaymentRequest;
import com.vinsguru.orderservice.model.payment.PaymentStatus;

public interface PaymentClient {

    PaymentStatus process(PaymentRequest request);

}
