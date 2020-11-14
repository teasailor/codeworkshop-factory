package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Worker {
    private final Service factoryService;
    private final de.conrad.codeworkshop.factory.services.notification.Service notificationService;

    @Autowired
    public Worker(Service factoryService,
                  de.conrad.codeworkshop.factory.services.notification.Service notificationService) {
        this.factoryService = factoryService;
        this.notificationService = notificationService;
    }

    @Async
    @Scheduled(fixedDelay = 10000)
    public void completeOrders() throws InterruptedException {
        List<Order> orders = factoryService.dequeueAll();
        System.out.println(orders.size() + " orders are completed.");
        Thread.sleep(5000);
        orders.forEach(notificationService::notifyCustomer);
    }
}
