package com.vinsguru.orderservice.service.impl;

import com.vinsguru.orderservice.model.order.OrderRequest;
import com.vinsguru.orderservice.model.order.OrderResponse;
import com.vinsguru.orderservice.orchestrator.OrderOrchestrator;
import com.vinsguru.orderservice.orchestrator.OrderState;
import com.vinsguru.orderservice.service.OrderService;
import com.vinsguru.orderservice.util.DomainDtoMapper;

public class OrderServiceImpl implements OrderService {

    private final OrderOrchestrator orderOrchestrator;

    public OrderServiceImpl(OrderOrchestrator orderOrchestrator) {
        this.orderOrchestrator = orderOrchestrator;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        var command = DomainDtoMapper.toCreateOrderCommand(request);
        var placedOrderState =  new OrderState.Placed(command);
        var orderState = this.orderOrchestrator.orchestrate(placedOrderState);
        return switch (orderState){
            case OrderState.Fulfilled fulfilled -> DomainDtoMapper.toOrderResponse(fulfilled.order(), fulfilled.invoice(), fulfilled.shipments());
            default -> throw new IllegalStateException("Unexpected value: " + orderState); // should not happen
        };
    }
}
