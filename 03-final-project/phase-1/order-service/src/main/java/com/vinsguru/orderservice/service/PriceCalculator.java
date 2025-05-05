package com.vinsguru.orderservice.service;

import com.vinsguru.orderservice.model.common.PriceSummary;
import com.vinsguru.orderservice.model.order.Order;

public interface PriceCalculator {

    PriceSummary calculate(Order order);

}
