package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.customer.Customer;
import org.springframework.boot.jackson.JacksonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Customer.Regular.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Customer.Regular.class),
        @JsonSubTypes.Type(Customer.Business.class),
})
@JacksonMixin(Customer.class)
public class CustomerMixIn {
}
