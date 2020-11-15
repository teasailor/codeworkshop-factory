This application represents a factory. Customers can create orders using the OrderController's create method. The order 
is then validated. If it is valid, its status will be set to ACCEPTED and it will get an OrderConfirmation and be put on a queue via the FactoryController. Otherwise it will get a BLANK_ORDER_CONFIRMATION.

There is also a notification service, that would then send a message to the customer once the order has been completed.

There are three open tasks for this project. Please work on them in this order and try to get as far as possible.

1. Extend the order validation so that Orders are only valid if the productId has between 6 and 9 digits (including) and the quantity is either 
* divisible by 10
* or less than one and larger than 0
* or exactly 42.42.
2. Adjust de.conrad.codeworkshop.factory.services.order.Controller so that it accepts and produces JSON.
3. Build a primitive asynchronous worker that will remove entries from de.conrad.codeworkshop.factory.services.factory.Service#manufacturingQueue, sets their status to COMPLETED, waits for five seconds and then calls de.conrad.codeworkshop.factory.services.notification.Service#notifyCustomer (to notify the customer that their order is completed).

Please be ready to present, demonstrate and send in your results.


# Points to improve 
## Technical
- fix NPEs
- use Bean Validation, use @Valid
- make errors clear for end users (for example, using validation errors, @ExceptionHandler)
- all hardcoded values should be under configuration
- configure logging (logback-spring.xml)
- use Lombok (toString)

## Style
- Services/Controllers should be properly named (otherwise inconvenient search and ugly imports)
- de.conrad.codeworkshop.factory.services.factory.Controller#enqueue can be simplified to one line
- it is not classic 3layer architecture because Service uses Controller (Services should not contain @PostMapping also)
- unconsolidated style: smth is marked as @Nullable but others are not

## Security
- "/factory/queue" is not a safe way to put an order to the queue, if it's for testing then it should be hidden from end users