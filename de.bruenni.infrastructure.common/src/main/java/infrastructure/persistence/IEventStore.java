package infrastructure.persistence;

import infrastructure.common.event.IEvent;
import infrastructure.common.event.ITenantEvent;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public interface IEventStore<TEvent extends IEvent,
        TTenantEvent extends ITenantEvent> extends CrudRepository<TEvent, EntityId> {
    /**
     * Finds aggregate by the corresponding aggregate id
     * @param id id of the aggregate to find.
     * @param eventType the type of event to find
     */
    Iterable<TEvent> findByAggregateId(EntityId id, Class eventType);

    /**
     * Gets all events by tenantid and event type.
     * @param tenantId the tenant id of the event entity.
     * @param eventType
     * @return
     */
    Iterable<TTenantEvent> findByTenantId(EntityId tenantId, Class eventType);
}
