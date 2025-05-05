package com.vinsguru.orderservice.model.product;

import java.time.LocalDate;
import java.util.List;

public sealed interface ProductStatus {

    record Active(Product product) implements ProductStatus {

    }

    record Discontinued(String productId,
                        String reason,
                        LocalDate discontinuedAt,
                        List<String> recommendedProducts) implements ProductStatus {

    }

}
