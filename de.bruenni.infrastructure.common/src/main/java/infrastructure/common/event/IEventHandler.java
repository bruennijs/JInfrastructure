package infrastructure.common.event;

import java.lang.reflect.Type;

/**
 * Created by bruenni on 08.06.16.
 */
public interface IEventHandler<T extends IEvent> {
    /**
     * handles event.
     * @param event
     */
    void OnEvent(T event);

    /**
     * Gets the array of event types this handler supports.
     * @return
     */
    Type[] getSupportedEvents();
}