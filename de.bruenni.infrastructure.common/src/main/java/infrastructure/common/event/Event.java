package infrastructure.common.event;

import infrastructure.persistence.IEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bruenni on 30.04.16.
 */
public interface Event<TId extends Serializable, TAggregate> extends IEntity<TId> {

    /**sabbat.location.core.domain.events.Ss
     * Gets the entity ID of domain event
     * @return
     */
    @Override
    TId getId();

    /**
     * Gets the
     * @return
     */
    Date getCreatedOn();

    /**
     * Gets the aggregate
     * @return
     */
    TAggregate getAggregate();
}
