package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.coupon.Coupon;
import org.springframework.boot.jackson.JacksonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Coupon.None.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Coupon.None.class),
        @JsonSubTypes.Type(Coupon.Flat.class),
        @JsonSubTypes.Type(Coupon.Percentage.class)
})
@JacksonMixin(Coupon.class)
public class CouponMixIn {
}
