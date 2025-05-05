package com.vinsguru.orderservice.orchestrator;

import com.vinsguru.orderservice.model.common.PriceSummary;
import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.order.CreateOrderCommand;
import com.vinsguru.orderservice.model.order.Order;
import com.vinsguru.orderservice.model.shipping.Shipment;

import java.util.List;

public sealed interface OrderState {

    record Placed(CreateOrderCommand request) implements OrderState {

    }

    record Validated(Order order) implements OrderState {

    }

    record Priced(Order order,
                  PriceSummary priceSummary) implements OrderState {

    }

    record Invoiced(Order order,
                    Invoice invoice) implements OrderState {

    }

    record Shipped(Order order,
                   Invoice invoice,
                   List<Shipment> shipments) implements OrderState {

    }

    record Fulfilled(Order order,
                     Invoice invoice,
                     List<Shipment> shipments) implements OrderState {

    }

}
