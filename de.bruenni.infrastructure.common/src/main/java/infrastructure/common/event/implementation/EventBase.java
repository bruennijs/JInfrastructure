package infrastructure.common.event.implementation;

import infrastructure.common.event.Event;
import infrastructure.persistence.Entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 30.04.16.
 */
public abstract class EventBase extends Entity<UUID> implements Event<UUID, UUID> {
    private final UUID aggregate;
    private Date timestamp = new Date();

    /**
     * Constructor with default values.
     * @param aggregateId Id of the aggregate this event was created by.
     */
    public EventBase(UUID aggregateId) {
        super(UUID.randomUUID());
        this.timestamp = new Date();
        this.aggregate = aggregateId;
    }

    /**
     * Constructor.
     * @param id
     */
    public EventBase(UUID id, UUID aggregate, Date timestamp) {
        super(id);
        this.aggregate = aggregate;
        this.timestamp = timestamp;
    }

    @Override
    public Date getCreatedOn() {
        return this.timestamp;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public UUID getAggregate() {
        return aggregate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "aggregate=" + aggregate +
                ", timestamp=" + timestamp +
                "} " + super.toString();
    }
}
