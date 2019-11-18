package de.conrad.codeworkshop.factory.services.order;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import de.conrad.codeworkshop.factory.services.order.api.OrderNumber;
import de.conrad.codeworkshop.factory.services.order.api.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Random;

/**
 * TODO what could be improved here?
 *
 * @author Andreas Hartmann
 */
@org.springframework.stereotype.Service
@RequestMapping("/order")
@RestController
public class Service {

    @Autowired
    de.conrad.codeworkshop.factory.services.factory.Controller factoryController;

    /**
     * TODO please make sure this method accepts and produces JSON.
     */
    @PostMapping("/create")
    public OrderConfirmation createOrder(final Order order) {
        order.validate();

        final OrderConfirmation orderConfirmation;

        if (order.getStatus() == OrderStatus.ACCEPTED) {
            orderConfirmation = new OrderConfirmation(new OrderNumber(BigInteger.valueOf(new Random().nextInt())));

            order.setOrderConfirmation(orderConfirmation);

            factoryController.enqueue(order);
        } else {
            orderConfirmation = new OrderConfirmation(null);
        }

        return orderConfirmation;
    }
}
