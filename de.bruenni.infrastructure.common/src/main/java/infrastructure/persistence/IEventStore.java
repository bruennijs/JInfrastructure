package infrastructure.persistence;

import infrastructure.common.event.IEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by bruenni on 18.06.16.
 */
public interface IEventStore<TEvent extends IEvent, TAggregateId> extends CrudRepository<TEvent, UUID> {
    /**
     * Finds aggregate by the corresponding aggregate id
     * @param id id of the aggregate to find.
     */
    void findByAggregateId(TAggregateId id);
}
