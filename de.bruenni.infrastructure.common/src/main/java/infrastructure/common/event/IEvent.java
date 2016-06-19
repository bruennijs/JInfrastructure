package infrastructure.common.event;

import infrastructure.persistence.EntityId;
import infrastructure.persistence.IEntity;
import org.w3c.dom.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 30.04.16.
 */
public interface IEvent<TId extends Serializable,
        TAggregateId extends Serializable> extends IEntity<TId> {

    /**
     * Gets the time of occurence.
     * @return
     */
    Date getTimestamp();

    /**
     * Gets the id of the aggregate this event has been raised by.
     * @return
     */
    TAggregateId getAggregateId();
}
