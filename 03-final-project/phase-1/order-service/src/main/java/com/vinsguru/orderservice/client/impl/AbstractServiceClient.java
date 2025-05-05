package com.vinsguru.orderservice.client.impl;

import com.vinsguru.orderservice.exception.ApplicationExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

abstract class AbstractServiceClient {

    private static final Logger log = LoggerFactory.getLogger(AbstractServiceClient.class);

    protected abstract String getServiceName();

    protected <T> T executeRequest(Supplier<T> supplier, Map<Integer, Supplier<T>> errorMap) {
        try {
            var t = supplier.get();
            log.info("response: {}", t);
            return t;
        } catch (HttpStatusCodeException ex) {
            log.error("error response from {}", this.getServiceName(), ex);
            return Optional.ofNullable(errorMap.get(ex.getStatusCode().value()))
                           .map(Supplier::get)
                           .orElseGet(() -> ApplicationExceptions.remoteServiceError(this.getServiceName(), ex.getMessage()));
        }
    }

}
