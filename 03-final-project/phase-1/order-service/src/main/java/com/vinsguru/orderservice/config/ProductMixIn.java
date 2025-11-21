package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.product.Product;
import org.springframework.boot.jackson.JacksonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Product.Single.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Product.Single.class),
        @JsonSubTypes.Type(Product.Bundle.class),
})
@JacksonMixin(Product.class)
public class ProductMixIn {
}
