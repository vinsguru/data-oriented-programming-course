package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.coupon.Coupon;

public interface CouponClient {

    Coupon getCoupon(String code);

}
