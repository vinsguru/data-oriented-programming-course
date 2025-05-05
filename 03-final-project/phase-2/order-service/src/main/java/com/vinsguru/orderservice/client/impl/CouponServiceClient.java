package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.CouponClient;
import com.vinsguru.orderservice.model.coupon.Coupon;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.function.Supplier;

public class CouponServiceClient extends AbstractServiceClient implements CouponClient {

    private final RestClient restClient;

    public CouponServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "coupon-service";
    }

    @Override
    public Coupon getCoupon(String code) {
        var errorMap = Map.<Integer, Supplier<Coupon>>of(
                404, Coupon::none
        );
        return this.executeRequest(
                () -> this.restClient.get()
                                     .uri("/{code}", code)
                                     .retrieve()
                                     .body(Coupon.class),
                errorMap
        );
    }

}
