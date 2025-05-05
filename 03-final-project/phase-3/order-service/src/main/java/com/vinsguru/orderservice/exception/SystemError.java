package com.vinsguru.orderservice.exception;

public sealed interface SystemError extends ApplicationError {

    record RemoteServiceError(String service,
                              String message) implements SystemError {

    }

}
