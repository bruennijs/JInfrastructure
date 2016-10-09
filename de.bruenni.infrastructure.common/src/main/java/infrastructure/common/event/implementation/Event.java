package infrastructure.common.event.implementation;

import infrastructure.common.event.IEvent;
import infrastructure.persistence.Entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 30.04.16.
 */
public abstract class Event extends Entity<UUID> implements IEvent<UUID, UUID> {
    private UUID aggregateId;
    private Date timestamp = new Date();

    /**
     * Constructor with default values.
     * @param aggregateId Id of the aggregate this event was created by.
     */
    public Event(UUID aggregateId) {
        super(UUID.randomUUID());
        this.timestamp = new Date();
        this.aggregateId = aggregateId;
    }

    /**
     * Constructor.
     * @param id
     */
    public Event(UUID id, UUID aggregateId, Date timestamp) {
        super(id);
        this.aggregateId = aggregateId;
        this.timestamp = timestamp;
    }

    @Override
    public UUID getAggregateId() {
        return aggregateId;
    }

    @Override
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "aggregateId=" + aggregateId +
                ", timestamp=" + timestamp +
                "} " + super.toString();
    }
}
