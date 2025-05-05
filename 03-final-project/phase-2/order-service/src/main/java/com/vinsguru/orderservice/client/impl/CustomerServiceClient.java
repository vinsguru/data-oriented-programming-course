package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.CustomerClient;
import com.vinsguru.orderservice.client.ProductClient;
import com.vinsguru.orderservice.exception.ApplicationExceptions;
import com.vinsguru.orderservice.model.customer.Customer;
import com.vinsguru.orderservice.model.product.ProductStatus;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.function.Supplier;

public class CustomerServiceClient extends AbstractServiceClient implements CustomerClient {

    private final RestClient restClient;

    public CustomerServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "customer-service";
    }

    @Override
    public Customer getCustomer(String customerId) {
        var errorMap = Map.<Integer, Supplier<Customer>>of(
                404, () -> ApplicationExceptions.customerNotFound(customerId)
        );
        return this.executeRequest(
                () -> this.restClient.get()
                                     .uri("/{customerId}", customerId)
                                     .retrieve()
                                     .body(Customer.class),
                errorMap
        );
    }

}
