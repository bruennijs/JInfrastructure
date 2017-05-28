package infrastructure.common.event.implementation;

import infrastructure.common.event.ITenantEvent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by bruenni on 19.06.16.
 */
public class TenantEvent extends EventBase implements ITenantEvent<UUID, UUID> {
    private UUID id;

    public TenantEvent(UUID id, UUID aggregateId, UUID tenantId, Date timestamp) {
        super(id, aggregateId, timestamp);
        this.id = tenantId;
    }

    @Override
    public UUID getTenantId() {
        return id;
    }
}
