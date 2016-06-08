package infrastructure.common.event.implementation;

import infrastructure.common.event.IEvent;

import java.util.Date;

/**
 * Created by bruenni on 30.04.16.
 */
public abstract class Event implements IEvent {
    private String id;
    private Date timestamp = new Date();

    /**
     * Constructor.
     * @param id
     */
    public Event(String id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    /**
     * Gets the id.
     * @return
     */
    public String getId() {
        return id;
    }

    @Override
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
