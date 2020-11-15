package de.conrad.codeworkshop.factory.services.order.api;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

/**
 * @author Andreas Hartmann
 */
public class Position {
    private Integer productId;
    private BigDecimal quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public boolean isValid() {
        int productIdSize = String.valueOf(productId).length();
        return productIdSize >= 6 && productIdSize <= 9
                && quantity.compareTo(ZERO) > 0 // my assumption
                && (quantity.remainder(TEN).equals(ZERO)
                || quantity.compareTo(ZERO) > 0 && quantity.compareTo(ONE) < 0
                || quantity.compareTo(valueOf(42.42)) == 0);
    }
}
