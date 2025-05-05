package com.vinsguru.orderservice.model.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderRequest(@NotBlank String customerId,
                           @NotBlank String productId,
                           @Min(1) int quantity,
                           String couponCode) {
}
