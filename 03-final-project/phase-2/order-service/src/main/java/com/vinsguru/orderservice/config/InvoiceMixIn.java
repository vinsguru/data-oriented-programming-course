package com.vinsguru.orderservice.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.product.Product;
import org.springframework.boot.jackson.JsonMixin;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION,
        defaultImpl = Invoice.Paid.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(Invoice.Paid.class),
        @JsonSubTypes.Type(Invoice.Unpaid.class),
})
@JsonMixin(Invoice.class)
public class InvoiceMixIn {
}
