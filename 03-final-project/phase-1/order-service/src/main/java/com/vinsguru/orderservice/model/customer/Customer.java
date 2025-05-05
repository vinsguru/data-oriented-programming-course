package com.vinsguru.orderservice.model.customer;

import com.vinsguru.orderservice.model.common.Address;

public sealed interface Customer {

    String id();
    String name();
    Address address();

    record Regular(String id,
                   String name,
                   Address address) implements Customer {

    }

    record Business(String id,
                    String name,
                    String taxId,
                    Address address) implements Customer {

    }

}
