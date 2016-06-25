package infrastructure.common.event;

import java.lang.reflect.Type;

/**
 * Created by bruenni on 08.06.16.
 */
public interface IEventHandler<T extends IEvent> {
    /**
     * Handles domain events.
     * @param event
     * @return handler can create new events itself. If no new event is created by the handler null is returned
     */
    void OnEvent(T event);

    /**
     * Gets the array of event types this handler supports.
     * @return
     */
    Type[] getSupportedEvents();
}