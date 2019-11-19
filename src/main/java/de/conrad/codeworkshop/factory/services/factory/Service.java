package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderStatus;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TODO please build an asynchronous worker that removes orders from the queue, set the status to completed and then
 * calls the notification service.
 *
 * @author Andreas Hartmann
 */
@org.springframework.stereotype.Service("factoryService")
class Service {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private ConcurrentLinkedQueue<Order> manufacturingQueue = new ConcurrentLinkedQueue<>();

    void enqueue(final Order order) {
        order.setStatus(OrderStatus.IN_PROGRESS);
        manufacturingQueue.add(order);
    }
}
