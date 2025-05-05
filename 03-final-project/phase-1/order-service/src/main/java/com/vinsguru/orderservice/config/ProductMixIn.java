package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.customer.Customer;
import com.vinsguru.orderservice.model.product.Product;
import org.springframework.boot.jackson.JsonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Product.Single.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Product.Single.class),
        @JsonSubTypes.Type(Product.Bundle.class),
})
@JsonMixin(Product.class)
public class ProductMixIn {
}
