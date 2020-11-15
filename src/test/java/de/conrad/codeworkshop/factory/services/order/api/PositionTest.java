package de.conrad.codeworkshop.factory.services.order.api;

import org.junit.Test;

import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Only valid if the productId has between 6 and 9 digits (including) and the quantity is either
 * divisible by 10
 * or less than one and larger than 0
 * or exactly 42.42.
 */
public class PositionTest {

    @Test
    public void testIsValid() {
        assertTrue(createValidPosition().isValid());
    }

    @Test
    public void testSmallProductId() {
        Position position = createValidPosition();
        position.setProductId(12);

        assertFalse(position.isValid());
    }

    @Test
    public void testBigProductId() {
        Position position = createValidPosition();
        position.setProductId(1234567890);

        assertFalse(position.isValid());
    }

    @Test
    public void testFractionalQuantity() {
        Position position = createValidPosition();
        position.setQuantity(valueOf(0.3));

        assertTrue(position.isValid());
    }

    @Test
    public void testHundredQuantity() {
        Position position = createValidPosition();
        position.setQuantity(valueOf(100));

        assertTrue(position.isValid());
    }

    @Test
    public void testInvalidQuantity() {
        Position position = createValidPosition();
        position.setQuantity(valueOf(1.7));

        assertFalse(position.isValid());
    }

    @Test
    public void testNegativeQuantity() {
        Position position = createValidPosition();
        position.setQuantity(valueOf(-100));

        assertFalse(position.isValid());
    }

    private Position createValidPosition() {
        Position position = new Position();
        position.setProductId(1234567);
        position.setQuantity(valueOf(42.42));
        return position;
    }
}