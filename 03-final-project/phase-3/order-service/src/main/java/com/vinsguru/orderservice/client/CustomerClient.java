package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.customer.Customer;

public interface CustomerClient {

    Customer getCustomer(String customerId);

}
