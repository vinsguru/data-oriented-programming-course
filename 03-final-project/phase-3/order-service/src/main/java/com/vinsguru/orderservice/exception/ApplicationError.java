package com.vinsguru.orderservice.exception;

public sealed interface ApplicationError permits DomainError, SystemError {
}
