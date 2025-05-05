package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.payment.PaymentRequest;
import com.vinsguru.orderservice.model.payment.PaymentStatus;
import com.vinsguru.orderservice.model.payment.RefundRequest;

public interface PaymentClient {

    PaymentStatus process(PaymentRequest request);

    void refund(RefundRequest request);

}
