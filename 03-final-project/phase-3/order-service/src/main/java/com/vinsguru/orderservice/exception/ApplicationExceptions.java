package com.vinsguru.orderservice.exception;

import com.vinsguru.orderservice.model.payment.PaymentStatus;
import com.vinsguru.orderservice.model.product.ProductStatus;
import com.vinsguru.orderservice.model.shipping.ShippingStatus;

public class ApplicationExceptions {

    public static <T> T customerNotFound(String id){
        var error = new DomainError.EntityNotFound(DomainError.Entity.CUSTOMER, id);
        throw new ApplicationException(error);
    }

    public static <T> T productNotFound(String id){
        var error = new DomainError.EntityNotFound(DomainError.Entity.PRODUCT, id);
        throw new ApplicationException(error);
    }

    public static <T> T discontinuedProduct(ProductStatus.Discontinued discontinued){
        var error = new DomainError.ProductDiscontinued(
            discontinued.productId(),
            discontinued.recommendedProducts()
        );
        throw new ApplicationException(error);
    }

    public static <T> T declinedPayment(PaymentStatus.Declined declined){
        var error = new DomainError.PaymentDeclined(
            declined.orderId(),
            declined.amount()
        );
        throw new ApplicationException(error);
    }

    public static <T> T declinedShipping(ShippingStatus.Declined declined){
        var error = new DomainError.ShippingDeclined(declined.orderId());
        throw new ApplicationException(error);
    }

    public static <T> T remoteServiceError(String service, String message){
        var error = new SystemError.RemoteServiceError(service, message);
        throw new ApplicationException(error);
    }

}
