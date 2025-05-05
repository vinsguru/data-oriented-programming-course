package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.coupon.Coupon;
import com.vinsguru.orderservice.model.customer.Customer;
import org.springframework.boot.jackson.JsonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Coupon.None.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Coupon.None.class),
        @JsonSubTypes.Type(Coupon.Flat.class),
        @JsonSubTypes.Type(Coupon.Percentage.class)
})
@JsonMixin(Coupon.class)
public class CouponMixIn {
}
