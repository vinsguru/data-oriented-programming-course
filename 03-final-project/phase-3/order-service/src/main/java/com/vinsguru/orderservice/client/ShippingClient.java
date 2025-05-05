package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.shipping.ShippingRequest;
import com.vinsguru.orderservice.model.shipping.ShippingStatus;

public interface ShippingClient {

    ShippingStatus schedule(ShippingRequest request);

}
