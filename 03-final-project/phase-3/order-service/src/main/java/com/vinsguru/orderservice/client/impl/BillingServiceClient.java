package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.client.BillingClient;
import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.invoice.InvoiceRequest;
import com.vinsguru.orderservice.model.invoice.InvoiceRequest.*;
import org.springframework.web.client.RestClient;

import java.util.Collections;

public class BillingServiceClient extends AbstractServiceClient implements BillingClient {

    private final RestClient restClient;

    public BillingServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    protected String getServiceName() {
        return "billing-service";
    }

    @Override
    public Invoice createInvoice(InvoiceRequest request) {
        return switch (request) {
            case Paid _ -> this.executeRequest("/invoices/paid", request);
            case Unpaid _ -> this.executeRequest("/invoices/unpaid", request);
        };
    }

    private Invoice executeRequest(String path, InvoiceRequest request) {
        return this.executeRequest(
                () -> this.restClient.post()
                                     .uri(path)
                                     .body(request)
                                     .retrieve()
                                     .body(Invoice.class),
                Collections.emptyMap()
        );
    }

    @Override
    public void cancelInvoice(String invoiceId) {
        this.executeRequest(
                () -> this.restClient.post()
                                     .uri("/invoices/{invoiceId}/cancel", invoiceId)
                                     .retrieve()
                                     .toBodilessEntity(),
                Collections.emptyMap()
        );
    }

}

