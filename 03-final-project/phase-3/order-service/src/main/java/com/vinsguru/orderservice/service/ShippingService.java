package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.order.Order;
import com.vinsguru.orderservice.model.shipping.ShippingStatus;

public interface ShippingService {

    ShippingStatus scheduleShipping(Order order);

}
