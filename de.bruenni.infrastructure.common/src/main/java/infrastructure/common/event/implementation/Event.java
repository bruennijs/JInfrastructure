package infrastructure.common.event.implementation;

import infrastructure.common.event.IEvent;
import infrastructure.persistence.Entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 30.04.16.
 */
public abstract class Event extends Entity<UUID> implements IEvent {
    private UUID id;
    private Date timestamp = new Date();

    /**
     * Constructor with default values.
     */
    public Event() {
        super(UUID.randomUUID());
        this.timestamp = new Date();
    }

    /**
     * Constructor.
     * @param id
     */
    public Event(UUID id, Date timestamp) {
        super(id);
        this.timestamp = timestamp;
    }

    /**
     * Gets the id.
     * @return
     */
    public UUID getId() {
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
