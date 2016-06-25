package infrastructure.common.event;

import infrastructure.persistence.EntityId;

import java.io.Serializable;

/**
 * Created by bruenni on 19.06.16.
 */
public interface ITenantEvent<TId extends Serializable, TAggregateId extends Serializable>
          extends IEvent<TId, TAggregateId>
{
    /**
     * Gets the tenant id.
     * @return
     */
    TId getTenantId();
}
