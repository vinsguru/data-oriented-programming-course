package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.shipping.ShippingRequest;
import com.vinsguru.orderservice.model.shipping.ShippingResponse;

public interface ShippingClient {

    ShippingResponse schedule(ShippingRequest request);

}
