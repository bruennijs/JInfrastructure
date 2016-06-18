package infrastructure.common.event;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IDomainEventBus extends IDomainEventPublisher {
    /**
     * Subcribes to domain event bus.
     * @return
     */
    rx.Observable<IEvent> subscribe();
}
