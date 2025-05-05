package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.order.CreateOrderCommand;
import com.vinsguru.orderservice.model.order.Order;

public interface RequestValidatorService {

    Order validate(CreateOrderCommand request);

}
