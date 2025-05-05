package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.common.PriceSummary;
import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.order.Order;

public interface PaymentBillingService {

    Invoice processPayment(Order order, PriceSummary priceSummary);

    void refundPayment(Invoice invoice);

}
