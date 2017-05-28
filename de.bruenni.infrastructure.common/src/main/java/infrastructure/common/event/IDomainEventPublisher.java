package infrastructure.common.event;

/**
 * Created by bruenni on 18.06.16.
 */
public interface IDomainEventPublisher {

    /**
     * Publishes event to all subscribers.
     * @param event
     */
    void publish(Event event);
}
