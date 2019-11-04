package de.conrad.codeworkshop.factory.services.order.api;

import java.math.BigInteger;

/**
 * @author Andreas Hartmann
 */
public class OrderNumber {
    private final BigInteger orderNumberPlain;

    public OrderNumber(BigInteger futureOrderNumberPlain) {
        orderNumberPlain = futureOrderNumberPlain;
    }

    public BigInteger getOrderNumberPlain() {
        return orderNumberPlain;
    }
}
