package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.product.Product;
import com.vinsguru.orderservice.model.product.ProductStatus;
import org.springframework.boot.jackson.JsonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = ProductStatus.Active.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(ProductStatus.Active.class),
        @JsonSubTypes.Type(ProductStatus.Discontinued.class),
})
@JsonMixin(ProductStatus.class)
public class ProductStatusMixIn {
}
