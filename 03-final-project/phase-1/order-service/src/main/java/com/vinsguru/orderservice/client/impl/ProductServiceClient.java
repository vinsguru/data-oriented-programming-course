package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.ProductClient;
import com.vinsguru.orderservice.exception.ApplicationExceptions;
import com.vinsguru.orderservice.model.product.ProductStatus;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.function.Supplier;

public class ProductServiceClient extends AbstractServiceClient implements ProductClient {

    private final RestClient restClient;

    public ProductServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "product-service";
    }

    @Override
    public ProductStatus getProduct(String productId) {
        var errorMap = Map.<Integer, Supplier<ProductStatus>>of(
                404, () -> ApplicationExceptions.productNotFound(productId)
        );
        return this.executeRequest(
                () -> this.restClient.get()
                                     .uri("/{productId}", productId)
                                     .retrieve()
                                     .body(ProductStatus.class),
                errorMap
        );
    }

}
