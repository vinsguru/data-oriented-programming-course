package com.vinsguru.orderservice.client;

import com.vinsguru.orderservice.model.invoice.Invoice;
import com.vinsguru.orderservice.model.invoice.InvoiceRequest;

public interface BillingClient {

    Invoice createInvoice(InvoiceRequest request);

    void cancelInvoice(String invoiceId);

}
