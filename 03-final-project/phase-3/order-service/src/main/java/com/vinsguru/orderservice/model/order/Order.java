package com.vinsguru.orderservice.model.order;

import com.vinsguru.orderservice.model.coupon.Coupon;
import com.vinsguru.orderservice.model.customer.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

public record Order(UUID orderId,
                    Customer customer,
                    OrderItem orderItem,
                    Coupon coupon,
                    LocalDateTime createdAt) {
}
