package de.bruenni.infrastructure.common.event;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IDomainEventBus<IEvent> {
    /**
     * Subcribes to domain event bus.
     * @return
     */
    rx.Observable<IEvent> subscribe();

    /**
     * Publishes event to all subscribers.
     * @param event
     */
    void publish(IEvent event);
}
