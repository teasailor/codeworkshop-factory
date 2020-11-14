package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Andreas Hartmann
 */
@RestController("factoryController")
@RequestMapping("/factory")
public class Controller {

    private final Service factoryService;

    @Autowired
    public Controller(final Service factoryService) {
        this.factoryService = factoryService;
    }

    @PostMapping(value = "/enqueue")
    public final HttpStatus enqueue(@RequestBody final Order order) {
        HttpStatus response = OK;
        try {
            factoryService.enqueue(order);
        } catch (final Exception exception) {
            response = INTERNAL_SERVER_ERROR;
        }
        return response;
    }

    @GetMapping("/queue")
    public List<Order> readOrders(){
        return factoryService.readOrders();
    }
}
