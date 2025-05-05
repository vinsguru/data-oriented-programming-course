package com.vinsguru.orderservice.orchestrator;

//  we can also name this OrderFulfillmentOrchestrator - it could be helpful when we have multiple orchestrators
public interface OrderOrchestrator {

    default OrderState orchestrate(OrderState orderState){
        return switch (orderState){
            case OrderState.Placed state -> this.orchestrate(this.handle(state));
            case OrderState.Validated state -> this.orchestrate(this.handle(state));
            case OrderState.Priced state -> this.orchestrate(this.handle(state));
            case OrderState.Invoiced state -> this.orchestrate(this.handle(state));
            case OrderState.Shipped state -> this.orchestrate(this.handle(state));
            case OrderState.Fulfilled state -> state;
        };
    }

    OrderState handle(OrderState.Placed placed);
    OrderState handle(OrderState.Validated validated);
    OrderState handle(OrderState.Priced priced);
    OrderState handle(OrderState.Invoiced invoiced);
    OrderState handle(OrderState.Shipped shipped);

}
