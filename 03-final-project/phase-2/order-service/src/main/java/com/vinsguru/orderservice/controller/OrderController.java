package com.vinsguru.orderservice.controller;

import com.vinsguru.orderservice.model.order.OrderRequest;
import com.vinsguru.orderservice.model.order.OrderResponse;
import com.vinsguru.orderservice.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("orders")
    public OrderResponse placeOrder(@Validated @RequestBody OrderRequest orderRequest){
        return this.orderService.placeOrder(orderRequest);
    }

}
