package infrastructure.common.event;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IEvent {
    /**
     * Gets the event id.
     * @return
     */
    UUID getId();

    /**
     * Gets the time of occurence.
     * @return
     */
    Date getTimestamp();
}
