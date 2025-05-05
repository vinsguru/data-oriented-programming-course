package com.vinsguru.orderservice.model.shipping;

import com.vinsguru.orderservice.model.common.Address;

public record Recipient(String name,
                        Address address) {
}
