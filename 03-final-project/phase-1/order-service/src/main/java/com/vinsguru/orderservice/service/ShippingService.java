package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.order.Order;
import com.vinsguru.orderservice.model.shipping.ShippingResponse;

public interface ShippingService {

    ShippingResponse scheduleShipping(Order order);

}
