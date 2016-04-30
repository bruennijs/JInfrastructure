package com.bruenni.infrastructure.common.event;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IDomainEventBus<TEvent> {
    /**
     * Subcribes to domain event bus.
     * @return
     */
    rx.Observable<TEvent> subscribe();

    /**
     * Publishes event to all subscribers.
     * @param event
     */
    void publish(TEvent event);
}
