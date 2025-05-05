package com.vinsguru.orderservice.service.impl;

import com.vinsguru.orderservice.client.CustomerClient;
import com.vinsguru.orderservice.client.ProductClient;
import com.vinsguru.orderservice.exception.ApplicationExceptions;
import com.vinsguru.orderservice.model.order.CreateOrderCommand;
import com.vinsguru.orderservice.model.order.Order;
import com.vinsguru.orderservice.model.order.OrderItem;
import com.vinsguru.orderservice.model.product.Product;
import com.vinsguru.orderservice.model.product.ProductStatus.*;
import com.vinsguru.orderservice.service.RequestValidatorService;

import java.time.LocalDateTime;

public class RequestValidatorServiceImpl implements RequestValidatorService {

    private final ProductClient productClient;
    private final CustomerClient customerClient;

    public RequestValidatorServiceImpl(ProductClient productClient, CustomerClient customerClient) {
        this.productClient = productClient;
        this.customerClient = customerClient;
    }

    @Override
    public Order validate(CreateOrderCommand request) {
        var product = this.getProduct(request.productId());
        var customer = this.customerClient.getCustomer(request.customerId());
        var orderItem = new OrderItem(product, request.quantity());
        return new Order(request.orderId(), customer, orderItem, LocalDateTime.now());
    }

    private Product getProduct(String productId){
        return switch (this.productClient.getProduct(productId)){
            case Active active -> active.product();
            case Discontinued discontinued -> ApplicationExceptions.discontinuedProduct(discontinued);
        };
    }

}
