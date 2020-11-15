package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.COMPLETED;
import static java.util.stream.Collectors.toList;

/**
 * @author Andreas Hartmann
 */
@org.springframework.stereotype.Service("factoryService")
class Service {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final ConcurrentLinkedQueue<Order> manufacturingQueue = new ConcurrentLinkedQueue<>();

    void enqueue(final Order order) {
        order.setStatus(OrderStatus.IN_PROGRESS);
        manufacturingQueue.add(order);
    }

    List<Order> dequeueAll() {
        List<Order> completedOrders = manufacturingQueue.stream()
                .peek(order -> order.setStatus(COMPLETED))
                .collect(toList());
        manufacturingQueue.removeAll(completedOrders);
        return completedOrders;
    }

    List<Order> readOrders() {
        return new ArrayList<>(manufacturingQueue);
    }
}
