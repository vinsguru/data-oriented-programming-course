package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.product.ProductStatus;

public interface ProductClient {

    ProductStatus getProduct(String productId);

}
