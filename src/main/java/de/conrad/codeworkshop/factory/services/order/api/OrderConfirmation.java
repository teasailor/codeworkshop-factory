package de.conrad.codeworkshop.factory.services.order.api;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.ACCEPTED;
import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.DECLINED;

/**
 * @author Andreas Hartmann
 */
public class OrderConfirmation {
    private OrderStatus status;
    private OrderNumber orderNumber;

    public OrderConfirmation(final OrderNumber orderNumber) {
        this.orderNumber = orderNumber;

        this.status = null == orderNumber ? ACCEPTED : DECLINED;
    }

    @Nullable
    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    @NotNull
    public OrderStatus getStatus() {
        return status;
    }
}
