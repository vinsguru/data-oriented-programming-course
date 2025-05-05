package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.order.OrderRequest;
import com.vinsguru.orderservice.model.order.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest request);

}
