package com.vinsguru.orderservice.orchestrator.impl;

import com.vinsguru.orderservice.exception.ApplicationExceptions;
import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.shipping.ShippingStatus;
import com.vinsguru.orderservice.orchestrator.OrderOrchestrator;
import com.vinsguru.orderservice.orchestrator.OrderState;
import com.vinsguru.orderservice.service.PaymentBillingService;
import com.vinsguru.orderservice.service.PriceCalculator;
import com.vinsguru.orderservice.service.RequestValidatorService;
import com.vinsguru.orderservice.service.ShippingService;

public class OrderOrchestratorImpl implements OrderOrchestrator {

    private final RequestValidatorService validatorService;
    private final PriceCalculator priceCalculator;
    private final PaymentBillingService paymentBillingService;
    private final ShippingService shippingService;

    public OrderOrchestratorImpl(RequestValidatorService validatorService, PriceCalculator priceCalculator, PaymentBillingService paymentBillingService, ShippingService shippingService) {
        this.validatorService = validatorService;
        this.priceCalculator = priceCalculator;
        this.paymentBillingService = paymentBillingService;
        this.shippingService = shippingService;
    }

    @Override
    public OrderState handle(OrderState.Placed placed) {
        var order = this.validatorService.validate(placed.request());
        return new OrderState.Validated(order);
    }

    @Override
    public OrderState handle(OrderState.Validated validated) {
        var priceSummary = this.priceCalculator.calculate(validated.order());
        return new OrderState.Priced(validated.order(), priceSummary);
    }

    @Override
    public OrderState handle(OrderState.Priced priced) {
        var invoice = this.paymentBillingService.processPayment(priced.order(), priced.priceSummary());
        return new OrderState.Invoiced(priced.order(), invoice);
    }

    @Override
    public OrderState handle(OrderState.Invoiced invoiced) {
        var shippingStatus = this.shippingService.scheduleShipping(invoiced.order());
        return switch (shippingStatus){
            case ShippingStatus.Scheduled scheduled -> new OrderState.Shipped(invoiced.order(), invoiced.invoice(), scheduled.shipments());
            case ShippingStatus.Declined declined -> this.handleDeclinedShipping(invoiced.invoice(), declined);
        };
    }

    @Override // this step might look unnecessary. but I have a dedicated lecture to explain why it is required.
    public OrderState handle(OrderState.Shipped shipped) {
        return new OrderState.Fulfilled(shipped.order(), shipped.invoice(), shipped.shipments());
    }

    private OrderState handleDeclinedShipping(Invoice invoice, ShippingStatus.Declined declined){
        this.paymentBillingService.refundPayment(invoice);
        return ApplicationExceptions.declinedShipping(declined);
    }

}
