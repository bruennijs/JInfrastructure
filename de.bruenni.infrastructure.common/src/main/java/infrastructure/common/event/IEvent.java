package infrastructure.common.event;

import java.util.Date;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IEvent {
    /**
     * Gets the event id.
     * @return
     */
    String getId();

    /**
     * Gets the time of occurence.
     * @return
     */
    Date getTimestamp();
}
