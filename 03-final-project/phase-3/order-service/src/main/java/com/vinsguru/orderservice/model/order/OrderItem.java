package com.vinsguru.orderservice.model.order;

import com.vinsguru.orderservice.model.product.Product;

public record OrderItem(Product product,
                        int quantity) {
}
