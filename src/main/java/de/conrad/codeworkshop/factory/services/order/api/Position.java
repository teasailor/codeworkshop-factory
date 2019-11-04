package de.conrad.codeworkshop.factory.services.order.api;

import java.math.BigDecimal;

/**
 * @author Andreas Hartmann
 */
public class Position {
    final Integer productId;
    final BigDecimal quantity;

    public Position(Integer productId, BigDecimal quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
